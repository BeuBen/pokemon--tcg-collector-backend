package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GoodiesType;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddGoodiesCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.GoodiesDTO;
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

  public static GoodiesDTO validGoodiesDTO() {
    return GoodiesDTO.builder()
        .id(1L)
        .collectorId(1L)
        .label("test")
        .goodiesType(GoodiesType.FIGURE)
        .condition(Condition.MINT)
        .estimation(ItemFixture.aValidEstimation())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .creationDate(LocalDateTime.MIN)
        .build();
  }

  public static AddGoodiesCommand aValidAddGoodiesCommand() {
    return AddGoodiesCommand.builder()
        .label("test")
        .goodiesType(GoodiesType.FIGURE)
        .condition(Condition.MINT)
        .estimationEuros(ItemFixture.aValidEstimation().getPriceInEuros())
        .estimationSourceUrl(ItemFixture.aValidEstimation().getSourceUrl())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .build();
  }
}
