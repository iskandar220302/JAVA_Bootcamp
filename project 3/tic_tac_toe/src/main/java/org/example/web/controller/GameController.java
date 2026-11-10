package org.example.web.controller;

import org.example.domain.model.Game;
import org.example.domain.model.GameField;
import org.example.domain.service.GameService;
import org.example.datasource.repository.GameRepository;
import org.example.web.mapper.GameMapper;
import org.example.web.mapper.GameFieldMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final GameFieldMapper fieldMapper;

    public GameController(
            GameService gameService,
            GameRepository gameRepository,
            GameMapper gameMapper,
            GameFieldMapper fieldMapper
    ) {
        this.gameService = gameService;
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
        this.fieldMapper = fieldMapper;
    }

    @PostMapping
    public ResponseEntity<org.example.web.model.Game> createGame() {
        Game game = new Game(
                UUID.randomUUID(),
                new GameField()
        );

        gameRepository.save(game);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(gameMapper.toWeb(game));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> makeMove(
            @PathVariable UUID id,
            @RequestBody org.example.web.model.Game request
    ) {
        if (request == null || request.getField() == null) {
            return ResponseEntity.badRequest()
                    .body("Game field must not be null");
        }

        if (!id.equals(request.getId())) {
            return ResponseEntity.badRequest()
                    .body("Game ID does not match URL");
        }

        Game updatedGame;

        try {
            updatedGame = gameMapper.toDomain(request);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest()
                    .body(exception.getMessage());
        }

        if (!gameService.validateGameField(
                updatedGame,
                updatedGame.getField()
        )) {
            return ResponseEntity.badRequest()
                    .body("Invalid game field or move");
        }

        GameField computerField =
                gameService.getNextMove(updatedGame);

        Game result = new Game(id, computerField);
        gameRepository.save(result);

        return ResponseEntity.ok(gameMapper.toWeb(result));
    }
}
