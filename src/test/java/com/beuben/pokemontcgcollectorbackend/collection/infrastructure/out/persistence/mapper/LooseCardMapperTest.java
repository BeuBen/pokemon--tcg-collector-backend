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
    final var model = aValidLooseCardEntity();
    final var expected = aValidLooseCard();

    // ACT
    final var mapped = mapper.toDomain(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}