package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddSealedCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.SealedDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.SealedEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.aValidEstimation;

public class SealedFixture {
  public static SealedEntity aValidSealedEntity() {
    return new SealedEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withProtected(true)
        .withProtectionCost(BigDecimal.TEN)
        .withCondition(Condition.MINT)
        .withEstimationEuros(aValidEstimation().getPriceInEuros())
        .withEstimationDate(aValidEstimation().getDate())
        .withEstimationSourceUrl(aValidEstimation().getSourceUrl())
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
        .withEstimation(aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static SealedDTO aValidSealedDTO() {
    return SealedDTO.builder()
        .id(1L)
        .collectorId(1L)
        .label("test")
        .hasProtection(true)
        .protectionCost(BigDecimal.TEN)
        .condition(Condition.MINT)
        .estimation(aValidEstimation())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .creationDate(LocalDateTime.MIN)
        .build();
  }

  public static AddSealedCommand aValidAddSealedCommand() {
    return AddSealedCommand.builder()
        .label("test")
        .hasProtection(true)
        .protectionCost(BigDecimal.TEN)
        .condition(Condition.MINT)
        .estimationEuros(aValidEstimation().getPriceInEuros())
        .estimationSourceUrl(aValidEstimation().getSourceUrl())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .build();
  }
}
