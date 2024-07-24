package com.beuben.pokemontcgcollectorbackend.collection.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import reactor.core.publisher.Flux;

public interface FetchAllSets {
  Flux<CardSet> execute();
}
