package com.beuben.pokemontcgcollectorbackend;

import com.beuben.pokemontcgcollectorbackend.core.configuration.application.pokemontcg.PokemonTcgApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    PokemonTcgApiConfiguration.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
