
package org.example.domain.service;

import org.example.domain.model.Game;
import org.example.domain.model.GameField;
import org.example.datasource.repository.GameRepository;

import java.util.Optional;

public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public boolean validateGameField(
            Game currentGame,
            GameField updatedField
    ) {
        if (currentGame == null || updatedField == null) {
            return false;
        }

        Optional<Game> savedGame =
                gameRepository.findById(currentGame.getId());

        if (savedGame.isEmpty()) {
            return false;
        }

        GameField previous = savedGame.get().getField();

        if (isGameOver(previous)) {
            return false;
        }

        int humanMoves = 0;

        for (int row = 0; row < GameField.SIZE; row++) {
            for (int col = 0; col < GameField.SIZE; col++) {
                int oldCell = previous.getCell(row, col);
                int newCell = updatedField.getCell(row, col);

                if (oldCell == newCell) {
                    continue;
                }

                if (oldCell != GameField.EMPTY
                        || newCell != GameField.HUMAN) {
                    return false;
                }

                humanMoves++;
            }
        }

        return humanMoves == 1;
    }

    @Override
    public GameField getNextMove(Game game) {
        GameField field = game.getField();

        if (isGameOver(field)) {
            return field;
        }

        int bestScore = Integer.MIN_VALUE;
        GameField bestField = field;

        for (int row = 0; row < GameField.SIZE; row++) {
            for (int col = 0; col < GameField.SIZE; col++) {
                if (!field.isEmpty(row, col)) {
                    continue;
                }

                GameField nextField =
                        field.withMove(row, col, GameField.COMPUTER);

                int score = minimax(nextField, false);

                if (score > bestScore) {
                    bestScore = score;
                    bestField = nextField;
                }
            }
        }

        return bestField;
    }

    @Override
    public boolean isGameOver(GameField field) {
        return getWinner(field) != GameField.EMPTY || field.isFull();
    }

    private int minimax(GameField field, boolean maximizing) {
        int winner = getWinner(field);

        if (winner == GameField.COMPUTER) {
            return 10;
        }

        if (winner == GameField.HUMAN) {
            return -10;
        }

        if (field.isFull()) {
            return 0;
        }

        if (maximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int row = 0; row < GameField.SIZE; row++) {
                for (int col = 0; col < GameField.SIZE; col++) {
                    if (field.isEmpty(row, col)) {
                        GameField next =
                                field.withMove(
                                        row, col, GameField.COMPUTER
                                );

                        bestScore = Math.max(
                                bestScore, minimax(next, false)
                        );
                    }
                }
            }

            return bestScore;
        }

        int bestScore = Integer.MAX_VALUE;

        for (int row = 0; row < GameField.SIZE; row++) {
            for (int col = 0; col < GameField.SIZE; col++) {
                if (field.isEmpty(row, col)) {
                    GameField next =
                            field.withMove(
                                    row, col, GameField.HUMAN
                            );

                    bestScore = Math.min(
                            bestScore, minimax(next, true)
                    );
                }
            }
        }

        return bestScore;
    }

    private int getWinner(GameField field) {
        int[][] lines = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] line : lines) {
            int first = getCellByIndex(field, line[0]);
            int second = getCellByIndex(field, line[1]);
            int third = getCellByIndex(field, line[2]);

            if (first != GameField.EMPTY
                    && first == second
                    && second == third) {
                return first;
            }
        }

        return GameField.EMPTY;
    }

    private int getCellByIndex(GameField field, int index) {
        return field.getCell(index / GameField.SIZE,
                index % GameField.SIZE);
    }
}
