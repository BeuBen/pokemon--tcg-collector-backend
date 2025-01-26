package com.beuben.pokemontcgcollectorbackend.catalog.fixture;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.dto.result.CardDTO;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity.CardEntity;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result.ExistingCardDTO;

import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardSetFixture.*;

public class CardFixture {

  public static CardEntity aValidCardEntity() {
    return new CardEntity()
        .withSetId(aCompleteSetEntity().getId())
        .withCode("base1-1")
        .withName("Alakazam")
        .withRarity("Rare Holo")
        .withNumber("1")
        .withImageUrl("https://images.pokemontcg.io/base1/1.png");
  }

  public static CardEntity aCompleteCardEntity() {
    return aValidCardEntity()
        .withSetId(aCompleteSetEntity().getId());
  }

  public static Card aValidCard() {
    return new Card()
        .withCode("base1-1")
        .withName("Alakazam")
        .withSet(aValidCardSet())
        .withRarity("Rare Holo")
        .withNumber("1")
        .withImage("https://images.pokemontcg.io/base1/1.png");
  }

  public static Card aSemiCompleteCard() {
    return aValidCard()
        .withSet(new CardSet().withId(aCompleteCardSet().getId()));
  }

  public static CardDTO aValidCardDto() {
    return CardDTO.builder()
        .code("base1-1")
        .name("Alakazam")
        .set(aValidSetDTO())
        .rarity("Rare Holo")
        .number("1")
        .image("https://images.pokemontcg.io/base1/1.png")
        .build();
  }

  public static ExistingCardDTO aValidExistingCardDto() {
    return ExistingCardDTO.builder()
        .code("base1-1")
        .name("Alakazam")
        .set(aValidExistingSetDTO())
        .rarity("Rare Holo")
        .number("1")
        .image("https://images.pokemontcg.io/base1/1.png")
        .build();
  }
}
