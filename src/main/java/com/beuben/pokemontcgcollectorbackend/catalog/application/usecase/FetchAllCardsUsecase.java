package com.beuben.pokemontcgcollectorbackend.catalog.application.usecase;

import com.beuben.pokemontcgcollectorbackend.catalog.application.port.in.FetchAllCards;
import com.beuben.pokemontcgcollectorbackend.catalog.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllCardsUsecase implements FetchAllCards {
  private final CardProvider provider;

  @Override
  public Flux<Card> execute() {
    return provider.findAll();
  }
}
