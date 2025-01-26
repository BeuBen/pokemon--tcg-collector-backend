package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardSetFixture.aValidCardSet;
import static com.beuben.pokemontcgcollectorbackend.catalog.fixture.CardSetFixture.aValidExistingSetDTO;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ExistingSetMapperTest {

  @Autowired
  private ExistingSetMapper mapper;

  @Test
  void set_mapping_should_return_the_right_existing_set_dto() {
    // ARRANGE
    final var model = aValidCardSet();
    final var expected = aValidExistingSetDTO();

    // ACT
    final var mapped = mapper.toDTO(model);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}