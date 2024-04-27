package com.beuben.pokemontcgcollectorbackend.updatedata.application.port.out.provider;

import com.beuben.pokemontcgcollectorbackend.updatedata.domain.card.Card;
import reactor.core.publisher.Flux;

public interface CardProvider {
  Flux<Card> findAll();
}
