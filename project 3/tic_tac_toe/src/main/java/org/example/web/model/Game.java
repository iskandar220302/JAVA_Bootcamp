package org.example.web.model;

import java.util.UUID;

public class Game {

    private UUID id;
    private GameField field;

    public Game() {
    }

    public Game(UUID id, GameField field) {
        this.id = id;
        this.field = field;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GameField getField() {
        return field;
    }

    public void setField(GameField field) {
        this.field = field;
    }
}
