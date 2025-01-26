package com.beuben.pokemontcgcollectorbackend.catalog.fixture;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.dto.result.SetDTO;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity.SetEntity;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result.ExistingSetDTO;

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

  public static SetDTO aValidSetDTO() {
    return SetDTO.builder()
        .code("base1")
        .name("Base")
        .series("Base")
        .cardTotal(102)
        .releaseDate(LocalDateTime.parse("1999-01-09T00:00"))
        .symbolImage("https://images.pokemontcg.io/base1/symbol.png")
        .logoImage("https://images.pokemontcg.io/base1/logo.png")
        .build();
  }

  public static ExistingSetDTO aValidExistingSetDTO() {
    return ExistingSetDTO.builder()
        .code("base1")
        .name("Base")
        .series("Base")
        .cardTotal(102)
        .releaseDate(LocalDateTime.parse("1999-01-09T00:00"))
        .symbolImage("https://images.pokemontcg.io/base1/symbol.png")
        .logoImage("https://images.pokemontcg.io/base1/logo.png")
        .build();
  }
}
