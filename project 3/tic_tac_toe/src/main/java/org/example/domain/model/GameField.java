
package org.example.domain.model;

import java.util.Arrays;

public class GameField {

    public static final int EMPTY = 0;
    public static final int HUMAN = 1;
    public static final int COMPUTER = 2;
    public static final int SIZE = 3;

    private final int[][] cells;

    public GameField() {
        this.cells = new int[SIZE][SIZE];
    }

    public GameField(int[][] cells) {
        if (cells == null || cells.length != SIZE) {
            throw new IllegalArgumentException("Invalid game field");
        }

        this.cells = new int[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            if (cells[row] == null || cells[row].length != SIZE) {
                throw new IllegalArgumentException("Invalid game field");
            }

            for (int col = 0; col < SIZE; col++) {
                int value = cells[row][col];

                if (value < EMPTY || value > COMPUTER) {
                    throw new IllegalArgumentException(
                            "Invalid cell value"
                    );
                }

                this.cells[row][col] = value;
            }
        }
    }

    public int getCell(int row, int col) {
        return cells[row][col];
    }

    public int[][] getCells() {
        int[][] copy = new int[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            copy[row] = Arrays.copyOf(cells[row], SIZE);
        }

        return copy;
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col] == EMPTY;
    }

    public boolean isFull() {
        for (int[] row : cells) {
            for (int cell : row) {
                if (cell == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    public GameField withMove(int row, int col, int player) {
        if (row < 0 || row >= SIZE ||
                col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Invalid move coordinates");
        }

        if (player != HUMAN && player != COMPUTER) {
            throw new IllegalArgumentException("Invalid player");
        }

        if (!isEmpty(row, col)) {
            throw new IllegalArgumentException("Cell is occupied");
        }

        int[][] copy = getCells();
        copy[row][col] = player;

        return new GameField(copy);
    }
}
