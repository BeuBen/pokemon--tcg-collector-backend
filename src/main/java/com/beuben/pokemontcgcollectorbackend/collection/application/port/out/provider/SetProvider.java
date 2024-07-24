package com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import reactor.core.publisher.Flux;

public interface SetProvider {
  Flux<CardSet> findAll();
}
