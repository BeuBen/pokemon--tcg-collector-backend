package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.fixture.ItemFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollector;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.SealedFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SealedMapperTest {

  @Autowired
  private SealedMapper mapper;

  @Test
  void add_sealed_command_mapping_should_return_the_right_sealed() {
    // ARRANGE
    final var collectorId = aValidCollector().getId();
    final var command = aValidAddSealedCommand();
    final var expected =
        aValidSealed()
            .withId(null)
            .withEstimation(ItemFixture.aValidEstimation()
                .withDate(null))
            .withCreationDate(null);

    // ACT
    final var mapped = mapper.toDomain(command, collectorId);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void sealed_mapping_should_return_the_right_sealed_dto() {
    // ARRANGE
    final var model = aValidSealed();
    final var expected = aValidSealedDTO();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}