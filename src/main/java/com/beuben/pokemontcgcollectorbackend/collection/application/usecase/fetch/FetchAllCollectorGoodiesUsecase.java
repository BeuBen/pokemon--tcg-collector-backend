package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchAllCollectorGoodies;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.CollectorProvider;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GoodiesProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllCollectorGoodiesUsecase implements FetchAllCollectorGoodies {
  private final CollectorProvider collectorProvider;
  private final GoodiesProvider goodiesProvider;

  @Override
  public Flux<Goodies> execute(final Long collectorId) {
    return collectorProvider.findById(collectorId)
        .flatMapMany(collector -> goodiesProvider.findAllByCollectorId(collector.getId()))
        .onErrorMap(CollectorNotFoundException.class,
            _ -> new NotFoundException(Collector.class, collectorId));
  }
}
