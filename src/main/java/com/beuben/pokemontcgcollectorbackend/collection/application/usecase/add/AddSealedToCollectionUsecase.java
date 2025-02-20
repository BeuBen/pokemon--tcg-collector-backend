package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.add;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.add.AddSealedToCollection;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.SealedProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AddSealedToCollectionUsecase implements AddSealedToCollection {
  private final SealedProvider provider;

  @Override
  public Mono<Sealed> execute(Sealed sealed) {
    return provider.add(sealed);
  }
}
