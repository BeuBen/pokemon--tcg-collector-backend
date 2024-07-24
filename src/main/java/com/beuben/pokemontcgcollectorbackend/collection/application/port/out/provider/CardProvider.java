package com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import reactor.core.publisher.Flux;

public interface CardProvider {
  Flux<Card> findAll();
}
