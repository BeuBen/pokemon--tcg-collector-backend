package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.fixture.SealedFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SealedMapperTest {

  @Autowired
  private SealedMapper mapper;

  @Test
  void sealed_entity_mapping_should_return_the_right_sealed() {
    // ARRANGE
    final var model = SealedFixture.aValidSealedEntity();
    final var expected = SealedFixture.aValidSealed();

    // ACT
    final var mapped = mapper.toDomain(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}