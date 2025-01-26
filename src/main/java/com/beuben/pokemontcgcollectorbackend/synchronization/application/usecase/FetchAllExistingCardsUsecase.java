package com.beuben.pokemontcgcollectorbackend.synchronization.application.usecase;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllExistingCards;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingCardProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllExistingCardsUsecase implements FetchAllExistingCards {
  private final ExistingCardProvider provider;

  @Override
  public Flux<Card> execute() {
    return provider.findAll();
  }
}
