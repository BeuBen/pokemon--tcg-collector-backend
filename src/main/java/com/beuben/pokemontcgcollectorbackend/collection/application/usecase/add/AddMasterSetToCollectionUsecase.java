package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.add;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.add.AddMasterSetToCollection;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.MasterSetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AddMasterSetToCollectionUsecase implements AddMasterSetToCollection {
  private final MasterSetProvider provider;

  @Override
  public Mono<MasterSet> execute(MasterSet masterSet) {
    return provider.add(masterSet);
  }
}
