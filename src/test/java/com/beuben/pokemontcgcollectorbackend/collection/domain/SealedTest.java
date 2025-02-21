package com.beuben.pokemontcgcollectorbackend.collection.domain;

import org.junit.jupiter.api.Test;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.SealedFixture.aValidSealed;
import static org.assertj.core.api.Assertions.assertThat;

class SealedTest {

  @Test
  void protected_sealed_estimation_should_sum_protection_cost_and_estimation() {
    // ARRANGE
    final var protectedSealedItem = aValidSealed();
    final var expectedEstimation = protectedSealedItem.getEstimation().getPriceInEuros()
        .add(protectedSealedItem.getProtectionCost());

    // ACT
    final var estimation = protectedSealedItem.getRelativeEstimationInEuros();

    // ASSERT
    assertThat(estimation).isEqualTo(expectedEstimation);
  }

  @Test
  void not_protected_sealed_estimation_should_return_only_estimation() {
    // ARRANGE
    final var notProtectedSealedItem = aValidSealed().withProtected(false);
    final var expectedEstimation = notProtectedSealedItem.getEstimation().getPriceInEuros();

    // ACT
    final var estimation = notProtectedSealedItem.getRelativeEstimationInEuros();

    // ASSERT
    assertThat(estimation).isEqualTo(expectedEstimation);
  }
}