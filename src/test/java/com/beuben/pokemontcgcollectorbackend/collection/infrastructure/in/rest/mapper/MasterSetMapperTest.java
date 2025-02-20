package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollector;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.aValidEstimation;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.MasterSetFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MasterSetMapperTest {

  @Autowired
  private MasterSetMapper mapper;

  @Test
  void add_master_set_command_mapping_should_return_the_right_master_set() {
    // ARRANGE
    final var collectorId = aValidCollector().getId();
    final var command = aValidAddMasterSetCommand();
    final var expected =
        aValidMasterSet()
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
  void master_set_mapping_should_return_the_right_master_set_dto() {
    // ARRANGE
    final var model = aValidMasterSet();
    final var expected = aValidMasterSetDTO();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}