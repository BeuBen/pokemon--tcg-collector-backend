package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in;

import com.beuben.pokemontcgcollectorbackend.synchronization.domain.Card;
import reactor.core.publisher.Flux;

public interface FetchAllCards {
  Flux<Card> execute();
}
