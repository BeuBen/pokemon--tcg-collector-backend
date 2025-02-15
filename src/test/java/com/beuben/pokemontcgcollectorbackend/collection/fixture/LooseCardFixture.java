package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.LooseCardEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LooseCardFixture {
  public static LooseCardEntity aValidLooseCardEntity() {
    return new LooseCardEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withCardId(1L)
        .withLanguage(Language.FRENCH)
        .withFirstEdition(false)
        .withReverseHolo(false)
        .withCondition(Condition.MINT)
        .withEstimationEuros(BigDecimal.TEN)
        .withEstimationDate(LocalDateTime.MIN)
        .withEstimationSourceUrl("estimation_url.com")
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static LooseCard aValidLooseCard() {
    return new LooseCard()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withCardId(1L)
        .withLanguage(Language.FRENCH)
        .withFirstEdition(false)
        .withReverseHolo(false)
        .withCondition(Condition.MINT)
        .withEstimation(ItemFixture.aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }
}
