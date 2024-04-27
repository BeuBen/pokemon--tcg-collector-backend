package com.beuben.pokemontcgcollectorbackend.core.configuration;

import com.beuben.pokemontcgcollectorbackend.core.configuration.database.PostgresqlConfiguration;
import com.beuben.pokemontcgcollectorbackend.core.util.Constants;
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
    datasource.setPoolName(Constants.POSTGRES_POOL_NAME);

    return datasource;
  }

  private String jdbcUrl(final String host, final Integer port, final String databaseName) {
    return Constants.JDBC_UNFORMATTED_URL
        .formatted(host, port, databaseName);
  }
}
