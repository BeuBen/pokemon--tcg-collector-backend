package com.beuben.pokemontcgcollectorbackend.core.configuration.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "api.pokemontcg")
public class PokemonTcgApi {
  private String endpoint;
  private String key;
}
