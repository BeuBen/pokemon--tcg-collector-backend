package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GoodiesFixture.aValidGoodies;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GoodiesFixture.aValidGoodiesEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GoodiesMapperTest {

  @Autowired
  private GoodiesMapper mapper;

  @Test
  void goodies_entity_mapping_should_return_the_right_goodies() {
    // ARRANGE
    final var model = aValidGoodiesEntity();
    final var expected = aValidGoodies();

    // ACT
    final var mapped = mapper.toDomain(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void goodies_mapping_should_return_the_right_goodies_entity() {
    // ARRANGE
    final var model = aValidGoodies();
    final var expected = aValidGoodiesEntity();

    // ACT
    final var mapped = mapper.toEntity(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}