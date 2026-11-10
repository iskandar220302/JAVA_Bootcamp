package org.example.web.model;

public class GameField {

    private int[][] cells;

    public GameField() {
    }

    public GameField(int[][] cells) {
        this.cells = cells;
    }

    public int[][] getCells() {
        return cells;
    }

    public void setCells(int[][] cells) {
        this.cells = cells;
    }
}
