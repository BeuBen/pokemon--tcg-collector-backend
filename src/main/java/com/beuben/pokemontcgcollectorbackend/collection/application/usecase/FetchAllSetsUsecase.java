package com.beuben.pokemontcgcollectorbackend.collection.application.usecase;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchAllSets;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider.SetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllSetsUsecase implements FetchAllSets {
  private final SetProvider provider;

  @Override
  public Flux<CardSet> execute() {
    return provider.findAll();
  }
}
