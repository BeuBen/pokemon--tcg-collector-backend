package com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

public interface SetProvider {
  Flux<CardSet> findAll();

  Mono<Void> saveAll(Set<CardSet> cards);

  Mono<Void> deleteAll(Set<CardSet> cards);
}
