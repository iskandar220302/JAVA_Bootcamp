
package org.example.datasource.mapper;

import org.example.domain.model.GameField;

public class GameFieldMapper {

    public org.example.datasource.model.GameField toDatasource(
            GameField field
    ) {
        return new org.example.datasource.model.GameField(
                field.getCells()
        );
    }

    public GameField toDomain(
            org.example.datasource.model.GameField field
    ) {
        return new GameField(field.getCells());
    }
}
