package com.beuben.pokemontcgcollectorbackend.catalog.application.port.in;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import reactor.core.publisher.Flux;

public interface FetchAllCards {
  Flux<Card> execute();
}
