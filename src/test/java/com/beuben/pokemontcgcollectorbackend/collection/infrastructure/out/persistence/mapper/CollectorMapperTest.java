package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollector;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollectorEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CollectorMapperTest {

  @Autowired
  private CollectorMapper mapper;

  @Test
  void card_dto_mapping_should_return_the_right_card() {
    // ARRANGE
    final var model = aValidCollectorEntity();
    final var expected = aValidCollector();

    // ACT
    final var mapped = mapper.toDomain(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}