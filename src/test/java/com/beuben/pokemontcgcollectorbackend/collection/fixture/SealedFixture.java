package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.SealedEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SealedFixture {
  public static SealedEntity aValidSealedEntity() {
    return new SealedEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withProtected(true)
        .withProtectionCost(BigDecimal.TEN)
        .withCondition(Condition.MINT)
        .withEstimationEuros(ItemFixture.aValidEstimation().getPriceInEuros())
        .withEstimationDate(ItemFixture.aValidEstimation().getDate())
        .withEstimationSourceUrl(ItemFixture.aValidEstimation().getSourceUrl())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static Sealed aValidSealed() {
    return new Sealed()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withProtected(true)
        .withProtectionCost(BigDecimal.TEN)
        .withCondition(Condition.MINT)
        .withEstimation(ItemFixture.aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }
}
