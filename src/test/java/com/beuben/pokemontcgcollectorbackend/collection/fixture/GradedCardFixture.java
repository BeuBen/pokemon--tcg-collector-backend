package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Grading;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddGradedCardCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.GradedCardDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.GradedCardEntity;

import java.time.LocalDateTime;

public class GradedCardFixture {
  public static GradedCardEntity aValidGradedCardEntity() {
    return new GradedCardEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withCardId(1L)
        .withLanguage(Language.FRENCH)
        .withFirstEdition(false)
        .withReverseHolo(false)
        .withGradingSociety("PSA")
        .withGrade("10")
        .withGradingReference("123456789")
        .withEstimationEuros(ItemFixture.aValidEstimation().getPriceInEuros())
        .withEstimationDate(ItemFixture.aValidEstimation().getDate())
        .withEstimationSourceUrl(ItemFixture.aValidEstimation().getSourceUrl())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static GradedCard aValidGradedCard() {
    return new GradedCard()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withCardId(1L)
        .withLanguage(Language.FRENCH)
        .withFirstEdition(false)
        .withReverseHolo(false)
        .withGrading(aValidGrading())
        .withEstimation(ItemFixture.aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static Grading aValidGrading() {
    return new Grading()
        .withSociety("PSA")
        .withGrade("10")
        .withReference("123456789");
  }

  public static GradedCardDTO aValidGradedCardDTO() {
    return GradedCardDTO.builder()
        .id(1L)
        .collectorId(1L)
        .label("test")
        .cardId(1L)
        .language(Language.FRENCH)
        .firstEdition(false)
        .reverseHolo(false)
        .grading(aValidGrading())
        .estimation(ItemFixture.aValidEstimation())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .creationDate(LocalDateTime.MIN)
        .build();
  }

  public static AddGradedCardCommand aValidAddGradedCardCommand() {
    return AddGradedCardCommand.builder()
        .label("test")
        .cardId(1L)
        .language(Language.FRENCH)
        .firstEdition(false)
        .reverseHolo(false)
        .gradingSociety(aValidGrading().getSociety())
        .grade(aValidGrading().getGrade())
        .gradingReference(aValidGrading().getReference())
        .estimationEuros(ItemFixture.aValidEstimation().getPriceInEuros())
        .estimationSourceUrl(ItemFixture.aValidEstimation().getSourceUrl())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .build();
  }
}
