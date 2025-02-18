package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GradedCardFixture.aValidGradedCard;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GradedCardFixture.aValidGradedCardEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GradedCardMapperTest {

  @Autowired
  private GradedCardMapper mapper;

  @Test
  void graded_card_entity_mapping_should_return_the_right_graded_card() {
    // ARRANGE
    final var entity = aValidGradedCardEntity();
    final var expected = aValidGradedCard();

    // ACT
    final var mapped = mapper.toDomain(entity);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void graded_card_mapping_should_return_the_right_graded_card_entity() {
    // ARRANGE
    final var model = aValidGradedCard();
    final var expected = aValidGradedCardEntity();

    // ACT
    final var mapped = mapper.toEntity(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}