package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.ItemFixture.aValidItem;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.ItemFixture.aValidItemDTO;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemMapperTest {

  @Autowired
  private ItemMapper mapper;

  @Test
  void item_mapping_should_return_the_right_item_dto() {
    // ARRANGE
    final var model = aValidItem();
    final var expected = aValidItemDTO();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}