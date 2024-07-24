package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg;

import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.PokemonTcgCardWrapperDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.PokemonTcgSetWrapperDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApiEndpoints.CARDS;
import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApiEndpoints.SETS;
import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApiParam.PAGE;

@Component
@RequiredArgsConstructor
public class PokemonTcgApi {
  private final WebClient pokemonTcgClient;

  public Mono<PokemonTcgCardWrapperDTO> findAllCards(final Integer page) {
    return pokemonTcgClient
        .get()
        .uri(uri -> uri.path(CARDS)
            .queryParam(PAGE, page)
            .build())
        .retrieve()
        .bodyToMono(PokemonTcgCardWrapperDTO.class);
  }

  public Mono<PokemonTcgSetWrapperDTO> findAllSets(final Integer page) {
    return pokemonTcgClient
        .get()
        .uri(uri -> uri.path(SETS)
            .queryParam(PAGE, page)
            .build())
        .retrieve()
        .bodyToMono(PokemonTcgSetWrapperDTO.class);
  }
}
