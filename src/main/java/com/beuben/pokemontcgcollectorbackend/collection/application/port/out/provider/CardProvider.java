package com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

public interface CardProvider {
  Flux<Card> findAll();

  Mono<Void> saveAll(Set<Card> cards);

  Mono<Void> deleteAll(Set<Card> cards);
}
