package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardFixture.aValidCard;
import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardFixture.aValidCardDto;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CardMapperTest {

  @Autowired
  private CardMapper mapper;

  @Test
  void card_mapping_should_return_the_right_card_dto() {
    // ARRANGE
    final var model = aValidCard();
    final var expected = aValidCardDto();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}