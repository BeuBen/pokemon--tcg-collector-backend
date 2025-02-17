package com.beuben.pokemontcgcollectorbackend.collection.application.usecase;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.AddGradedCardToCollection;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GradedCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AddGradedCardToCollectionUsecase implements AddGradedCardToCollection {
  private final GradedCardProvider provider;

  @Override
  public Mono<GradedCard> execute(GradedCard gradedCard) {
    return provider.add(gradedCard);
  }
}
