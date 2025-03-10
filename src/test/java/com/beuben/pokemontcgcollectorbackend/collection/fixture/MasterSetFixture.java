package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddMasterSetCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.MasterSetDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.MasterSetEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.aValidEstimation;

public class MasterSetFixture {
  public static MasterSetEntity aValidMasterSetEntity() {
    return new MasterSetEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withSetId(1L)
        .withCompletionRate(BigDecimal.ONE)
        .withCondition(Condition.MINT)
        .withEstimationEuros(aValidEstimation().getPriceInEuros())
        .withEstimationDate(aValidEstimation().getDate())
        .withEstimationSourceUrl(aValidEstimation().getSourceUrl())
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
        .withEstimation(aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static MasterSetDTO aValidMasterSetDTO() {
    return MasterSetDTO.builder()
        .id(1L)
        .collectorId(1L)
        .label("test")
        .cardSetId(1L)
        .completionRate(BigDecimal.ONE)
        .condition(Condition.MINT)
        .estimation(aValidEstimation())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .creationDate(LocalDateTime.MIN)
        .build();
  }

  public static AddMasterSetCommand aValidAddMasterSetCommand() {
    return AddMasterSetCommand.builder()
        .label("test")
        .setId(1L)
        .completionRate(BigDecimal.ONE)
        .condition(Condition.MINT)
        .estimationEuros(aValidEstimation().getPriceInEuros())
        .estimationSourceUrl(aValidEstimation().getSourceUrl())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .build();
  }
}
