package org.example.domain.service;

import org.example.domain.model.Game;
import org.example.domain.model.GameField;

public interface GameService {

    GameField getNextMove(Game game);

    boolean validateGameField(
            Game currentGame,
            GameField updatedField
    );

    boolean isGameOver(GameField field);
}
