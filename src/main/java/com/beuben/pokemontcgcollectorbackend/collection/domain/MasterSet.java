package com.beuben.pokemontcgcollectorbackend.collection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class MasterSet {
  private Long id;
  private Long collectorId;
  private String label;
  private Long setId;
  private BigDecimal completionRate;
  private Condition condition;
  private Estimation estimation;
  private String picturesUrl;
  private String comment;
  private LocalDateTime creationDate;

  public BigDecimal getRelativeEstimationInEuros(
      List<GradedCard> gradedCardsFromMasterSet,
      List<LooseCard> looseCardsFromMasterSet) {
    final var gradedCardsValue =
        gradedCardsFromMasterSet.stream()
            .map(card -> card.getEstimation().getPriceInEuros());
    final var looseCardsValue =
        looseCardsFromMasterSet.stream()
            .map(card -> card.getEstimation().getPriceInEuros());

    final var totalCardsValue =
        Stream.concat(gradedCardsValue, looseCardsValue)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    final var masterSetValue = estimation.getPriceInEuros().multiply(completionRate);

    return totalCardsValue.max(masterSetValue);
  }
}
