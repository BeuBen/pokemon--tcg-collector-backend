package com.beuben.pokemontcgcollectorbackend.fixture.core;

import lombok.Getter;

@Getter
public class PokemonTcgApiFixture {
  private final String url;
  private final String key;

  public PokemonTcgApiFixture() {
    this.url = "https://api.pokemontcg.io/v2";
    this.key = "123456";
  }
}
