package com.beuben.pokemontcgcollectorbackend.synchronization.fixture;

import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgImageDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgSetDTO;

public class CardSetFixture {
  public static PokemonTcgSetDTO aValidPokemonTcgSetDTO() {
    return new PokemonTcgSetDTO(
        "base1",
        "Base",
        "Base",
        102,
        "1999/01/09",
        PokemonTcgImageDTO.builder()
            .logo("https://images.pokemontcg.io/base1/logo.png")
            .symbol("https://images.pokemontcg.io/base1/symbol.png")
            .build());
  }
}
