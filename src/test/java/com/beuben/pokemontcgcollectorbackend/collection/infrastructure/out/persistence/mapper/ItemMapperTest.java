package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.ItemFixture.aValidItem;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.ItemFixture.aValidItemEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemMapperTest {

  @Autowired
  private ItemMapper mapper;

  @Test
  void item_entity_mapping_should_return_the_right_item() {
    // ARRANGE
    final var model = aValidItemEntity();
    final var expected = aValidItem();

    // ACT
    final var mapped = mapper.toDomain(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}