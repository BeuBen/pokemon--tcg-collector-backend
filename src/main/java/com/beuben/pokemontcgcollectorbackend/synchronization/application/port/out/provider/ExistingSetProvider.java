package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import reactor.core.publisher.Flux;

public interface ExistingSetProvider {
  Flux<CardSet> findAll();
}
