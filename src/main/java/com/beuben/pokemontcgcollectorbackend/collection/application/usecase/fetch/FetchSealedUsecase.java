package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchSealed;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.SealedProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.SealedNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FetchSealedUsecase implements FetchSealed {
  private final SealedProvider provider;

  @Override
  public Mono<Sealed> execute(Long id) {
    return provider.findById(id)
        .onErrorMap(SealedNotFoundException.class,
            _ -> new NotFoundException(Sealed.class, id));
  }
}
