package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollector;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.aValidEstimation;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.LooseCardFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LooseCardMapperTest {

  @Autowired
  private LooseCardMapper mapper;

  @Test
  void add_loose_card_command_mapping_should_return_the_right_loose_card() {
    // ARRANGE
    final var collectorId = aValidCollector().getId();
    final var command = aValidAddLooseCardCommand();
    final var expected =
        aValidLooseCard()
            .withId(null)
            .withEstimation(aValidEstimation()
                .withDate(null))
            .withCreationDate(null);

    // ACT
    final var mapped = mapper.toDomain(command, collectorId);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void loose_card_mapping_should_return_the_right_loose_card_dto() {
    // ARRANGE
    final var model = aValidLooseCard();
    final var expected = aValidLooseCardDTO();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}