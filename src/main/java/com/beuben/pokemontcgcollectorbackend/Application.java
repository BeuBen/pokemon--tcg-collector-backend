package com.beuben.pokemontcgcollectorbackend;

import com.beuben.pokemontcgcollectorbackend.core.configuration.api.PokemonTcgApiConfiguration;
import com.beuben.pokemontcgcollectorbackend.core.configuration.database.PostgresqlConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    PokemonTcgApiConfiguration.class,
    PostgresqlConfiguration.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
