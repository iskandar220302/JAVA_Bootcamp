package org.example.web.mapper;

import org.example.domain.model.Game;

public class GameMapper {

    private final GameFieldMapper fieldMapper;

    public GameMapper(GameFieldMapper fieldMapper) {
        this.fieldMapper = fieldMapper;
    }

    public Game toDomain(org.example.web.model.Game game) {
        if (game == null || game.getId() == null) {
            throw new IllegalArgumentException(
                    "Game and game id must not be null"
            );
        }

        return new Game(
                game.getId(),
                fieldMapper.toDomain(game.getField())
        );
    }

    public org.example.web.model.Game toWeb(Game game) {
        return new org.example.web.model.Game(
                game.getId(),
                fieldMapper.toWeb(game.getField())
        );
    }
}
