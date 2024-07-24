package com.beuben.pokemontcgcollectorbackend.synchronization.application.usecase;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllExistingSets;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingSetProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllExistingSetsUsecase implements FetchAllExistingSets {
  private final ExistingSetProvider provider;

  @Override
  public Flux<CardSet> execute() {
    return provider.findAll();
  }
}
