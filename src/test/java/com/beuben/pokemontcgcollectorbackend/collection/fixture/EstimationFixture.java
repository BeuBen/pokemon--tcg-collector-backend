package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CollectionEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CollectionEstimationDetail;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.UpdateItemEstimationCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.CollectionEstimationDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.CollectionEstimationDetailDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class EstimationFixture {
  public static Estimation aValidEstimation() {
    return new Estimation()
        .withPriceInEuros(BigDecimal.TEN)
        .withDate(LocalDateTime.MIN)
        .withSourceUrl("estimation_url.com");
  }

  public static CollectionEstimation aValidCollectionEstimation() {
    return new CollectionEstimation()
        .withEstimationInEuros(aValidEstimation().getPriceInEuros())
        .withDetail(aValidCollectionEstimationDetail());
  }

  public static Map<ItemType, CollectionEstimationDetail> aValidCollectionEstimationDetail() {
    return Map.of(ItemType.GRADED_CARD,
        new CollectionEstimationDetail()
            .withQuantity(1)
            .withEstimationInEuros(GradedCardFixture.aValidGradedCard().getEstimation().getPriceInEuros()));
  }

  public static CollectionEstimationDTO aValidCollectionEstimationDTO() {
    return CollectionEstimationDTO.builder()
        .estimationInEuros(aValidEstimation().getPriceInEuros())
        .detail(aValidCollectionEstimationDetailDTO())
        .build();
  }

  public static Map<ItemType, CollectionEstimationDetailDTO> aValidCollectionEstimationDetailDTO() {
    return Map.of(ItemType.GRADED_CARD,
        CollectionEstimationDetailDTO.builder()
            .quantity(1)
            .estimationInEuros(GradedCardFixture.aValidGradedCard().getEstimation().getPriceInEuros())
            .build());
  }

  public static UpdateItemEstimationCommand aValidUpdateItemEstimationCommand() {
    return UpdateItemEstimationCommand.builder()
        .estimationEuros(BigDecimal.TEN)
        .estimationSourceUrl("estimation_url.com")
        .build();
  }
}
