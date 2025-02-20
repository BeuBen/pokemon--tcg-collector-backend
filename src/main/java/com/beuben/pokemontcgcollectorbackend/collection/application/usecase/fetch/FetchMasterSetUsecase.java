package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchMasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.MasterSetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.MasterSetNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FetchMasterSetUsecase implements FetchMasterSet {
  private final MasterSetProvider provider;

  @Override
  public Mono<MasterSet> execute(Long id) {
    return provider.findById(id)
        .onErrorMap(MasterSetNotFoundException.class,
            _ -> new NotFoundException(MasterSet.class, id));
  }
}
