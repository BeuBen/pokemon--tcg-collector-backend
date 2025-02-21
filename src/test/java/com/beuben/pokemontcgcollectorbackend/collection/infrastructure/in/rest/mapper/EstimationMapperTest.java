package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EstimationMapperTest {

  @Autowired
  private EstimationMapper mapper;

  @Test
  void update_item_estimation_command_mapping_should_return_the_right_estimation() {
    // ARRANGE
    final var command = aValidUpdateItemEstimationCommand();
    final var expected = aValidEstimation().withDate(null);

    // ACT
    final var mapped = mapper.toDomain(command);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void collection_estimation_mapping_should_return_the_right_collection_estimation_dto() {
    // ARRANGE
    final var model = aValidCollectionEstimation();
    final var expected = aValidCollectionEstimationDTO();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}