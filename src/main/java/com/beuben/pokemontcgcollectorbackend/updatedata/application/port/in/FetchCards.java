package com.beuben.pokemontcgcollectorbackend.updatedata.application.port.in;

import com.beuben.pokemontcgcollectorbackend.updatedata.domain.card.Card;
import reactor.core.publisher.Flux;

public interface FetchCards {
  Flux<Card> execute();
}
