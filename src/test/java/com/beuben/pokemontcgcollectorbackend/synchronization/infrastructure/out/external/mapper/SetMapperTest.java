package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CardSetFixture.aValidCardSet;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CardSetFixture.aValidPokemonTcgSetDTO;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SetMapperTest {

  @Autowired
  private SetMapper mapper;

  @Test
  void set_dto_mapping_should_return_the_right_card_set() {
    // ARRANGE
    final var model = aValidPokemonTcgSetDTO();
    final var expected = aValidCardSet();

    // ACT
    final var mapped = mapper.toDomain(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}