package com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.out.external.api.pokemontcg;

import com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.out.external.dto.PokemonTcgCardDTO;
import com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.out.external.dto.PokemonTcgCardWrapperDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class PokemonTcgApi {
  private final WebClient pokemonTcgClient;

  public Flux<PokemonTcgCardDTO> findAll() {
    return pokemonTcgClient
        .get()
        .uri(PokemonTcgApiEndpoints.CARDS)
        .retrieve()
        .bodyToMono(PokemonTcgCardWrapperDTO.class)
        .flatMapIterable(PokemonTcgCardWrapperDTO::data);
  }
}
