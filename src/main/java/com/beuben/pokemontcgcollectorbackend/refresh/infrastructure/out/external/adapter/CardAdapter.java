package com.beuben.pokemontcgcollectorbackend.refresh.infrastructure.out.external.adapter;

import com.beuben.pokemontcgcollectorbackend.refresh.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.refresh.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.refresh.infrastructure.out.external.api.pokemontcg.PokemonTcgApi;
import com.beuben.pokemontcgcollectorbackend.refresh.infrastructure.out.external.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class CardAdapter implements CardProvider {
  private final PokemonTcgApi pokemonTcgApi;
  private final CardMapper mapper;

  @Override
  public Flux<Card> findAll() {
    return pokemonTcgApi.findAll()
        .map(mapper::toDomain);
  }
}
