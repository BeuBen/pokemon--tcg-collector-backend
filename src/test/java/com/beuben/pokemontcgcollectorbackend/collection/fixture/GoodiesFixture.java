package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GoodiesType;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.GoodiesEntity;

import java.time.LocalDateTime;

public class GoodiesFixture {
  public static GoodiesEntity aValidGoodiesEntity() {
    return new GoodiesEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withGoodiesType(GoodiesType.FIGURE)
        .withCondition(Condition.MINT)
        .withEstimationEuros(ItemFixture.aValidEstimation().getPriceInEuros())
        .withEstimationDate(ItemFixture.aValidEstimation().getDate())
        .withEstimationSourceUrl(ItemFixture.aValidEstimation().getSourceUrl())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static Goodies aValidGoodies() {
    return new Goodies()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withGoodiesType(GoodiesType.FIGURE)
        .withCondition(Condition.MINT)
        .withEstimation(ItemFixture.aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }
}
