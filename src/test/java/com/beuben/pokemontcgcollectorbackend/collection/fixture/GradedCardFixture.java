package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Grading;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.GradedCardEntity;

import java.math.BigDecimal;
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
        .withEstimationEuros(BigDecimal.TEN)
        .withEstimationDate(LocalDateTime.MIN)
        .withEstimationSourceUrl("estimation_url.com")
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
}
