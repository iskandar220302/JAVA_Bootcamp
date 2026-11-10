
package org.example.web.mapper;

import org.example.domain.model.GameField;

public class GameFieldMapper {

    public GameField toDomain(
            org.example.web.model.GameField field
    ) {
        if (field == null || field.getCells() == null) {
            throw new IllegalArgumentException(
                    "Game field must not be null"
            );
        }

        return new GameField(field.getCells());
    }

    public org.example.web.model.GameField toWeb(
            GameField field
    ) {
        return new org.example.web.model.GameField(
                field.getCells()
        );
    }
}
