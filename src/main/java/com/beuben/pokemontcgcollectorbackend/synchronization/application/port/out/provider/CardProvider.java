package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.synchronization.domain.card.Card;
import reactor.core.publisher.Flux;

public interface CardProvider {
  Flux<Card> findAll();
}