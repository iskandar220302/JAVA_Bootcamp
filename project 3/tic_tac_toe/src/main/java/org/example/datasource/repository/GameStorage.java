package org.example.datasource.repository;

import org.example.datasource.model.Game;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GameStorage {

    private final ConcurrentMap<UUID, Game> games =
            new ConcurrentHashMap<>();

    public void save(Game game) {
        games.put(game.getId(), game);
    }

    public Optional<Game> findById(UUID id) {
        return Optional.ofNullable(games.get(id));
    }

    public boolean existsById(UUID id) {
        return games.containsKey(id);
    }
}
