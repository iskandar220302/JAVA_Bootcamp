
package org.example.datasource.model;

public class GameField {

    private final int[][] cells;

    public GameField(int[][] cells) {
        this.cells = new int[cells.length][];

        for (int i = 0; i < cells.length; i++) {
            this.cells[i] = cells[i].clone();
        }
    }

    public int[][] getCells() {
        int[][] copy = new int[cells.length][];

        for (int i = 0; i < cells.length; i++) {
            copy[i] = cells[i].clone();
        }

        return copy;
    }
}
