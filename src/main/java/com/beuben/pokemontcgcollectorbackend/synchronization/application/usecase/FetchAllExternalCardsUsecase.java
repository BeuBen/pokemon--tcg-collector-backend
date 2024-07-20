package com.beuben.pokemontcgcollectorbackend.synchronization.application.usecase;

import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllCards;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.domain.card.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
@Qualifier("fetchAllExternalCardsUsecase")
public class FetchAllExternalCardsUsecase implements FetchAllCards {
  @Qualifier("externalCardAdapter") private final CardProvider provider;

  @Override
  public Flux<Card> execute() {
    return provider.findAll();
  }
}
