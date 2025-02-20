package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.add;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.add.AddLooseCardToCollection;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.LooseCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AddLooseCardToCollectionUsecase implements AddLooseCardToCollection {
  private final LooseCardProvider provider;

  @Override
  public Mono<LooseCard> execute(LooseCard looseCard) {
    return provider.add(looseCard);
  }
}
