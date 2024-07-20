package com.beuben.pokemontcgcollectorbackend.synchronization.application.usecase;

import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.RefreshCards;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.RefreshProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RefreshCardsUsecase implements RefreshCards {
  private final RefreshProvider provider;

  @Override
  public Mono<Void> execute() {
    return provider.refreshCards();
  }
}
