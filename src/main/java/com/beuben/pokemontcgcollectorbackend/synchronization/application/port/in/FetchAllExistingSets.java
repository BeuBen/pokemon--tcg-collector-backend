package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import reactor.core.publisher.Flux;

public interface FetchAllExistingSets {
  Flux<CardSet> execute();
}
