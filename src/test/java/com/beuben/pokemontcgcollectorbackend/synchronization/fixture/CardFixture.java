package com.beuben.pokemontcgcollectorbackend.synchronization.fixture;

import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgCardDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgImageDTO;

import static com.beuben.pokemontcgcollectorbackend.synchronization.fixture.CardSetFixture.aValidPokemonTcgSetDTO;

public class CardFixture {
  public static PokemonTcgCardDTO aValidPokemonTcgCardDTO() {
    return new PokemonTcgCardDTO(
        "base1-1",
        "Alakazam",
        aValidPokemonTcgSetDTO(),
        "1",
        "Rare Holo",
        PokemonTcgImageDTO.builder()
            .small("https://images.pokemontcg.io/base1/1.png")
            .build());
  }
}
