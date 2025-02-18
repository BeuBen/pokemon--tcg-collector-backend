package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.LooseCardFixture.aValidLooseCard;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.LooseCardFixture.aValidLooseCardEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LooseCardMapperTest {

  @Autowired
  private LooseCardMapper mapper;

  @Test
  void loose_card_entity_mapping_should_return_the_right_loose_card() {
    // ARRANGE
    final var entity = aValidLooseCardEntity();
    final var expected = aValidLooseCard();

    // ACT
    final var mapped = mapper.toDomain(entity);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void loose_card_mapping_should_return_the_right_loose_card_entity() {
    // ARRANGE
    final var model = aValidLooseCard();
    final var expected = aValidLooseCardEntity();

    // ACT
    final var mapped = mapper.toEntity(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}