package com.beuben.pokemontcgcollectorbackend.collection.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.aValidEstimation;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GradedCardFixture.aValidGradedCard;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.MasterSetFixture.aValidMasterSet;
import static org.assertj.core.api.Assertions.assertThat;

class MasterSetTest {

  @Test
  void master_set_estimation_with_more_valuable_cards_should_return_sum_of_cards_estimation() {
    // ARRANGE
    final var masterSet = aValidMasterSet()
        .withEstimation(aValidEstimation().withPriceInEuros(BigDecimal.ONE));

    final var gradedCardFromMasterSet = aValidGradedCard()
        .withEstimation(aValidEstimation().withPriceInEuros(BigDecimal.TEN))
        .withFromMasterSet(true)
        .withMasterSetId(masterSet.getId());

    final var expectedEstimation = gradedCardFromMasterSet.getEstimation().getPriceInEuros();

    // ACT
    final var estimation =
        masterSet.getRelativeEstimationInEuros(
            List.of(gradedCardFromMasterSet),
            Collections.emptyList());

    // ASSERT
    assertThat(estimation).isEqualTo(expectedEstimation);
  }

  @Test
  void master_set_estimation_with_less_valuable_cards_should_return_master_set_estimation() {
    // ARRANGE
    final var masterSet = aValidMasterSet()
        .withEstimation(aValidEstimation().withPriceInEuros(BigDecimal.TEN));

    final var gradedCardFromMasterSet = aValidGradedCard()
        .withEstimation(aValidEstimation().withPriceInEuros(BigDecimal.ONE))
        .withFromMasterSet(true)
        .withMasterSetId(masterSet.getId());

    final var expectedEstimation =
        masterSet.getEstimation().getPriceInEuros()
            .multiply(masterSet.getCompletionRate());

    // ACT
    final var estimation =
        masterSet.getRelativeEstimationInEuros(
            List.of(gradedCardFromMasterSet),
            Collections.emptyList());

    // ASSERT
    assertThat(estimation).isEqualTo(expectedEstimation);
  }
}