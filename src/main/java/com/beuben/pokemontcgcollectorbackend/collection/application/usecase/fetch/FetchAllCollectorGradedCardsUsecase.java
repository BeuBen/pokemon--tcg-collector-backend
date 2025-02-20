package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchAllCollectorGradedCards;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.CollectorProvider;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GradedCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllCollectorGradedCardsUsecase implements FetchAllCollectorGradedCards {
  private final CollectorProvider collectorProvider;
  private final GradedCardProvider gradedCardProvider;

  @Override
  public Flux<GradedCard> execute(final Long collectorId) {
    return collectorProvider.findById(collectorId)
        .flatMapMany(collector -> gradedCardProvider.findAllByCollectorId(collector.getId()))
        .onErrorMap(CollectorNotFoundException.class,
            _ -> new NotFoundException(Collector.class, collectorId));
  }
}
