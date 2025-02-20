package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchAllCollectorLooseCards;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.CollectorProvider;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.LooseCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllCollectorLooseCardsUsecase implements FetchAllCollectorLooseCards {
  private final CollectorProvider collectorProvider;
  private final LooseCardProvider looseCardProvider;

  @Override
  public Flux<LooseCard> execute(final Long collectorId) {
    return collectorProvider.findById(collectorId)
        .flatMapMany(collector -> looseCardProvider.findAllByCollectorId(collector.getId()))
        .onErrorMap(CollectorNotFoundException.class,
            _ -> new NotFoundException(Collector.class, collectorId));
  }
}
