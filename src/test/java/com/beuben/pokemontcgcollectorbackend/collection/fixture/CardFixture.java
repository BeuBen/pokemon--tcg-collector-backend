package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.CardEntity;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CardSetFixture.aCompleteSetEntity;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CardSetFixture.aValidCardSet;

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
        .withSetId(27L);
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
        .withSet(new CardSet().withId(27L));
  }
}
