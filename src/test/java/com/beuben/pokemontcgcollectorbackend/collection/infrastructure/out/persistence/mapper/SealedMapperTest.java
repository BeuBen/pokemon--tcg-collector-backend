package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.SealedFixture.aValidSealed;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.SealedFixture.aValidSealedEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SealedMapperTest {

  @Autowired
  private SealedMapper mapper;

  @Test
  void sealed_entity_mapping_should_return_the_right_sealed() {
    // ARRANGE
    final var entity = aValidSealedEntity();
    final var expected = aValidSealed();

    // ACT
    final var mapped = mapper.toDomain(entity);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void sealed_mapping_should_return_the_right_sealed_entity() {
    // ARRANGE
    final var model = aValidSealed();
    final var expected = aValidSealedEntity();

    // ACT
    final var mapped = mapper.toEntity(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}