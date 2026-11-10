package org.example.datasource.repository;

import org.example.datasource.mapper.GameMapper;
import org.example.domain.model.Game;

import java.util.Optional;
import java.util.UUID;

public class GameRepositoryImpl implements GameRepository {

    private final GameStorage storage;
    private final GameMapper gameMapper;

    public GameRepositoryImpl(
            GameStorage storage,
            GameMapper gameMapper
    ) {
        this.storage = storage;
        this.gameMapper = gameMapper;
    }

    @Override
    public void save(Game game) {
        storage.save(gameMapper.toDatasource(game));
    }

    @Override
    public Optional<Game> findById(UUID id) {
        return storage.findById(id)
                .map(gameMapper::toDomain);
    }
}
