package com.beuben.pokemontcgcollectorbackend.core.configuration;

import com.beuben.pokemontcgcollectorbackend.core.configuration.database.PostgresqlConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfiguration {
  private final PostgresqlConfiguration postgresqlConfiguration;

  @Bean
  public DataSource datasource() {
    final var datasource = new HikariDataSource();

    final var jdbcUrl = jdbcUrl(
        postgresqlConfiguration.getHost(),
        postgresqlConfiguration.getPort(),
        postgresqlConfiguration.getDatabase());

    datasource.setJdbcUrl(jdbcUrl);
    datasource.setUsername(postgresqlConfiguration.getUsername());
    datasource.setPassword(postgresqlConfiguration.getPassword());
    datasource.setPoolName("pokemon-tcg-collector-hikari");

    return datasource;
  }

  private String jdbcUrl(final String host, final Integer port, final String databaseName) {
    return "jdbc:postgresql://%s:%s/%s".formatted(host, port, databaseName);
  }
}
