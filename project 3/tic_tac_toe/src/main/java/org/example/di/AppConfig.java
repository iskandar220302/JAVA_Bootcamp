
package org.example.di;

import org.example.datasource.mapper.GameMapper;
import org.example.datasource.repository.GameRepository;
import org.example.datasource.repository.GameRepositoryImpl;
import org.example.datasource.repository.GameStorage;
import org.example.domain.service.GameService;
import org.example.domain.service.GameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GameStorage gameStorage() {
        return new GameStorage();
    }

    @Bean
    public org.example.datasource.mapper.GameFieldMapper
    datasourceGameFieldMapper() {
        return new org.example.datasource.mapper.GameFieldMapper();
    }

    @Bean
    public GameMapper datasourceGameMapper(
            org.example.datasource.mapper.GameFieldMapper mapper
    ) {
        return new GameMapper(mapper);
    }

    @Bean
    public GameRepository gameRepository(
            GameStorage storage,
            GameMapper mapper
    ) {
        return new GameRepositoryImpl(storage, mapper);
    }

    @Bean
    public GameService gameService(GameRepository repository) {
        return new GameServiceImpl(repository);
    }

    @Bean
    public org.example.web.mapper.GameFieldMapper webGameFieldMapper() {
        return new org.example.web.mapper.GameFieldMapper();
    }

    @Bean
    public org.example.web.mapper.GameMapper webGameMapper(
            org.example.web.mapper.GameFieldMapper mapper
    ) {
        return new org.example.web.mapper.GameMapper(mapper);
    }
}
