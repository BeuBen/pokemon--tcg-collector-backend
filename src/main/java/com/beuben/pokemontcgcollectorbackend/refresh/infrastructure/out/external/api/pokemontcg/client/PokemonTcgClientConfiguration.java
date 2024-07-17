package com.beuben.pokemontcgcollectorbackend.refresh.infrastructure.out.external.api.pokemontcg.client;

import com.beuben.pokemontcgcollectorbackend.core.configuration.application.pokemontcg.PokemonTcgApiConfiguration;
import com.beuben.pokemontcgcollectorbackend.core.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
public class PokemonTcgClientConfiguration {

  @Bean
  public WebClient pokemonTcgClient(PokemonTcgApiConfiguration apiConfiguration) {
    final var httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    httpHeaders.set(Constants.HTTP_HEADER_API_KEY, apiConfiguration.getKey());

    return WebClient.builder()
        .baseUrl(apiConfiguration.getUrl())
        .defaultHeaders(headers -> headers.addAll(httpHeaders))
        .exchangeStrategies(ExchangeStrategies.builder()
            .codecs(configurer -> configurer
                .defaultCodecs()
                .maxInMemorySize(Constants.HTTP_MAX_IN_MEMORY_SIZE))
            .build())
        .build();
  }
}
