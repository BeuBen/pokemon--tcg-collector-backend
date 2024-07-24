package com.beuben.pokemontcgcollectorbackend.collection.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import reactor.core.publisher.Flux;

public interface FetchAllCards {
  Flux<Card> execute();
}
