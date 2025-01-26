package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardSetFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SetMapperTest {

  @Autowired
  private SetMapper mapper;

  @Test
  void card_set_mapping_should_return_right_set_entity() {
    // ARRANGE
    final var model = aValidCardSet();
    final var expected = aValidSetEntity();

    // ACT
    final var mapped = mapper.toEntity(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void set_entity_mapping_should_return_right_card_set() {
    // ARRANGE
    final var model = aCompleteSetEntity();
    final var expected = aCompleteCardSet();

    // ACT
    final var mapped = mapper.toCardSet(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}