package com.beuben.pokemontcgcollectorbackend.core.configuration.application.pokemontcg;

import com.beuben.pokemontcgcollectorbackend.fixture.core.PokemonTcgApiFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class PokemonTcgApiConfigurationTest {

  @Autowired
  private PokemonTcgApiConfiguration pokemonTcgApiConfiguration;

  @Test
  void binding_property_file_should_return_object_with_all_fields_set() {
    // ASSIGN
    final var expectedApiConfig = new PokemonTcgApiFixture();

    // ASSERT
    assertEquals(expectedApiConfig.getUrl(), pokemonTcgApiConfiguration.getUrl());
    assertEquals(expectedApiConfig.getKey(), pokemonTcgApiConfiguration.getKey());
  }
}
