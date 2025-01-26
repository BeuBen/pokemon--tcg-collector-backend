package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardFixture.aValidCard;
import static com.beuben.pokemontcgcollectorbackend.synchronization.fixture.CardFixture.aValidPokemonTcgCardDTO;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CardMapperTest {

  @Autowired
  private CardMapper mapper;

  @Test
  void card_dto_mapping_should_return_the_right_card() {
    // ARRANGE
    final var model = aValidPokemonTcgCardDTO();
    final var expected = aValidCard();

    // ACT
    final var mapped = mapper.toDomain(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}