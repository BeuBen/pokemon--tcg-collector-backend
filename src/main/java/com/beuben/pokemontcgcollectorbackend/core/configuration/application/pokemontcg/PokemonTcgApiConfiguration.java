package com.beuben.pokemontcgcollectorbackend.core.configuration.application.pokemontcg;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "api.pokemontcg")
public class PokemonTcgApiConfiguration {
  private String url;
  private String key;
}
