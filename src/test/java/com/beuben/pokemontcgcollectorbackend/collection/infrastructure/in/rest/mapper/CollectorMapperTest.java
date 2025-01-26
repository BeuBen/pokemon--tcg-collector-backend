package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollector;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.CollectorFixture.aValidCollectorDTO;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CollectorMapperTest {

  @Autowired
  CollectorMapper mapper;

  @Test
  void collector_mapping_should_return_the_right_collector_dto() {
    // ARRANGE
    final var model = aValidCollector();
    final var expected = aValidCollectorDTO();

    // ACT
    final var mapped = mapper.toDto(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}