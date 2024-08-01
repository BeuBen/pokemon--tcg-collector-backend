package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.SetEntity;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgImageDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgSetDTO;

import java.time.LocalDateTime;

public class CardSetFixture {

  public static SetEntity aValidSetEntity() {
    return new SetEntity()
        .withCode("base1")
        .withName("Base")
        .withSeries("Base")
        .withCardTotal(102)
        .withReleaseDate(LocalDateTime.parse("1999-01-09T00:00"))
        .withSymbolUrl("https://images.pokemontcg.io/base1/symbol.png")
        .withLogoUrl("https://images.pokemontcg.io/base1/logo.png");
  }

  public static SetEntity aCompleteSetEntity() {
    return aValidSetEntity()
        .withId(27L);
  }

  public static CardSet aValidCardSet() {
    return new CardSet()
        .withCode("base1")
        .withName("Base")
        .withSeries("Base")
        .withCardTotal(102)
        .withReleaseDate(LocalDateTime.parse("1999-01-09T00:00:00"))
        .withSymbolImage("https://images.pokemontcg.io/base1/symbol.png")
        .withLogoImage("https://images.pokemontcg.io/base1/logo.png");
  }

  public static CardSet aCompleteCardSet() {
    return aValidCardSet()
        .withId(27L);
  }

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
