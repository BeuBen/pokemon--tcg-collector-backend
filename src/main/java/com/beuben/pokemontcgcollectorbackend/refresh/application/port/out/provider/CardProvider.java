package com.beuben.pokemontcgcollectorbackend.refresh.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.refresh.domain.card.Card;
import reactor.core.publisher.Flux;

public interface CardProvider {
  Flux<Card> findAll();
}
