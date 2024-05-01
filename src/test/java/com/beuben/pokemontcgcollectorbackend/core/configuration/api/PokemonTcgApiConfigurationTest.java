package com.beuben.pokemontcgcollectorbackend.core.configuration.api;

import com.beuben.pokemontcgcollectorbackend.fixture.core.configuration.api.PokemonTcgApiFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableConfigurationProperties(PokemonTcgApiConfiguration.class)
@TestPropertySource("classpath:application.properties")
class PokemonTcgApiConfigurationTest {
  @Autowired
  private PokemonTcgApiConfiguration pokemonTcgApiConfiguration;

  @Test
  void whenBindingPropertiesFile_thenAllFieldsAreSet() {
    // ASSIGN
    final var expectedApiConfig = new PokemonTcgApiFixture();

    // ACT

    // ASSERT
    assertEquals(expectedApiConfig.getUrl(), pokemonTcgApiConfiguration.getUrl());
    assertEquals(expectedApiConfig.getKey(), pokemonTcgApiConfiguration.getKey());
  }
}
