package com.beuben.pokemontcgcollectorbackend.catalog.application.port.in;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import reactor.core.publisher.Flux;

public interface FetchAllSets {
  Flux<CardSet> execute();
}
