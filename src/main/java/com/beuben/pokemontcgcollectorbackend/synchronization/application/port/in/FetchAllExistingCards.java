package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import reactor.core.publisher.Flux;

public interface FetchAllExistingCards {
  Flux<Card> execute();
}
