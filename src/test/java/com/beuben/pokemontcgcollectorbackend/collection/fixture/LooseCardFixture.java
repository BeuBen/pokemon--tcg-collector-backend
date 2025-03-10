package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddLooseCardCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.LooseCardDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.LooseCardEntity;

import java.time.LocalDateTime;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.aValidEstimation;

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
        .withEstimationEuros(aValidEstimation().getPriceInEuros())
        .withEstimationDate(aValidEstimation().getDate())
        .withEstimationSourceUrl(aValidEstimation().getSourceUrl())
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
        .withEstimation(aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withComment("a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static LooseCardDTO aValidLooseCardDTO() {
    return LooseCardDTO.builder()
        .id(1L)
        .collectorId(1L)
        .label("test")
        .cardId(1L)
        .language(Language.FRENCH)
        .firstEdition(false)
        .reverseHolo(false)
        .condition(Condition.MINT)
        .estimation(aValidEstimation())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .creationDate(LocalDateTime.MIN)
        .build();
  }

  public static AddLooseCardCommand aValidAddLooseCardCommand() {
    return AddLooseCardCommand.builder()
        .label("test")
        .cardId(1L)
        .language(Language.FRENCH)
        .firstEdition(false)
        .reverseHolo(false)
        .condition(Condition.MINT)
        .estimationEuros(aValidEstimation().getPriceInEuros())
        .estimationSourceUrl(aValidEstimation().getSourceUrl())
        .picturesUrl("pictures_url.com")
        .comment("a comment")
        .build();
  }
}
