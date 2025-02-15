package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.MasterSetEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MasterSetFixture {
  public static MasterSetEntity aValidMasterSetEntity() {
    return new MasterSetEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withSetId(1L)
        .withCompletionRate(BigDecimal.ONE)
        .withCondition(Condition.MINT)
        .withEstimationEuros(BigDecimal.TEN)
        .withEstimationDate(LocalDateTime.MIN)
        .withEstimationSourceUrl("estimation_url.com")
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static MasterSet aValidMasterSet() {
    return new MasterSet()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withSetId(1L)
        .withCompletionRate(BigDecimal.ONE)
        .withCondition(Condition.MINT)
        .withEstimation(ItemFixture.aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }
}
