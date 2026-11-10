package org.example.datasource.repository;

import org.example.domain.model.Game;

import java.util.Optional;
import java.util.UUID;

public interface GameRepository {

    void save(Game game);

    Optional<Game> findById(UUID id);
}
