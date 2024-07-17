package com.beuben.pokemontcgcollectorbackend.refresh.application.port.in;

import com.beuben.pokemontcgcollectorbackend.refresh.domain.card.Card;
import reactor.core.publisher.Flux;

public interface FetchCards {
  Flux<Card> execute();
}
