package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchAllCollectorSealed;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.CollectorProvider;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.SealedProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllCollectorSealedUsecase implements FetchAllCollectorSealed {
  private final CollectorProvider collectorProvider;
  private final SealedProvider sealedProvider;

  @Override
  public Flux<Sealed> execute(final Long collectorId) {
    return collectorProvider.findById(collectorId)
        .flatMapMany(collector -> sealedProvider.findAllByCollectorId(collector.getId()))
        .onErrorMap(CollectorNotFoundException.class,
            _ -> new NotFoundException(Collector.class, collectorId));
  }
}
