package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import reactor.core.publisher.Flux;

public interface ExistingCardProvider {
  Flux<Card> findAll();
}
