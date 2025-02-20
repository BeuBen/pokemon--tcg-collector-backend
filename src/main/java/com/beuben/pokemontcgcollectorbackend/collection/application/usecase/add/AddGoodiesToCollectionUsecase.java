package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.add;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.add.AddGoodiesToCollection;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GoodiesProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AddGoodiesToCollectionUsecase implements AddGoodiesToCollection {
  private final GoodiesProvider provider;

  @Override
  public Mono<Goodies> execute(Goodies goodies) {
    return provider.add(goodies);
  }
}
