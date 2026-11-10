
package org.example.datasource.mapper;

import org.example.domain.model.Game;

public class GameMapper {

    private final GameFieldMapper fieldMapper;

    public GameMapper(GameFieldMapper fieldMapper) {
        this.fieldMapper = fieldMapper;
    }

    public org.example.datasource.model.Game toDatasource(
            Game game
    ) {
        return new org.example.datasource.model.Game(
                game.getId(),
                fieldMapper.toDatasource(game.getField())
        );
    }

    public Game toDomain(
            org.example.datasource.model.Game game
    ) {
        return new Game(
                game.getId(),
                fieldMapper.toDomain(game.getField())
        );
    }
}
