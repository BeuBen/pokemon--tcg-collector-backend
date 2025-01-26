package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CardMapperTest {

  @Autowired
  private CardMapper mapper;

  @Test
  void card_mapping_should_return_the_right_card_entity() {
    // ARRANGE
    final var model = aSemiCompleteCard();
    final var expected = aValidCardEntity();

    // ACT
    final var mapped = mapper.toEntity(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void card_entity_mapping_should_return_the_right_card() {
    // ARRANGE
    final var model = aCompleteCardEntity();
    final var expected = aSemiCompleteCard();

    // ACT
    final var mapped = mapper.toCard(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}