package com.beuben.pokemontcgcollectorbackend.collection.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import reactor.core.publisher.Mono;

public interface AddLooseCardToCollection {
  Mono<LooseCard> execute(LooseCard looseCard);
}
