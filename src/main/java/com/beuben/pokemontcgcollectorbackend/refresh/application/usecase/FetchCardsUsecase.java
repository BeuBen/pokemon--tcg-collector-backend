package com.beuben.pokemontcgcollectorbackend.refresh.application.usecase;

import com.beuben.pokemontcgcollectorbackend.refresh.application.port.in.FetchCards;
import com.beuben.pokemontcgcollectorbackend.refresh.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.refresh.domain.card.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchCardsUsecase implements FetchCards {
  private final CardProvider provider;

  @Override
  public Flux<Card> execute() {
    return provider.findAll();
  }
}
