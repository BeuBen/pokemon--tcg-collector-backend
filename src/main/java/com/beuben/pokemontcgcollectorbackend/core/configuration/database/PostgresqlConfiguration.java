package com.beuben.pokemontcgcollectorbackend.core.configuration.database;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "postgres")
public class PostgresqlConfiguration {
  private String host;
  private Integer port;
  private String username;
  private String password;
  private String database;
}
