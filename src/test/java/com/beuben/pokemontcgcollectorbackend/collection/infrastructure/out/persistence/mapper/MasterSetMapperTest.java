package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.MasterSetFixture.aValidMasterSet;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.MasterSetFixture.aValidMasterSetEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MasterSetMapperTest {

  @Autowired
  private MasterSetMapper mapper;

  @Test
  void master_set_entity_mapping_should_return_the_right_master_set() {
    // ARRANGE
    final var entity = aValidMasterSetEntity();
    final var expected = aValidMasterSet();

    // ACT
    final var mapped = mapper.toDomain(entity);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void master_set_mapping_should_return_the_right_master_set_entity() {
    // ARRANGE
    final var model = aValidMasterSet();
    final var expected = aValidMasterSetEntity();

    // ACT
    final var mapped = mapper.toEntity(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}