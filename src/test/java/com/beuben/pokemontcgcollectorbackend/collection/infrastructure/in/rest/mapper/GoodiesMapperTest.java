package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.fixture.ItemFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollector;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GoodiesFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GoodiesMapperTest {

  @Autowired
  private GoodiesMapper mapper;

  @Test
  void add_goodies_command_mapping_should_return_the_right_goodies() {
    // ARRANGE
    final var collectorId = aValidCollector().getId();
    final var command = aValidAddGoodiesCommand();
    final var expected =
        aValidGoodies()
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
  void goodies_mapping_should_return_the_right_goodies_dto() {
    // ARRANGE
    final var model = aValidGoodies();
    final var expected = validGoodiesDTO();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}