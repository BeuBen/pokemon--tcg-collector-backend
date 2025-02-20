package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchAllCollectorItems;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.CollectorProvider;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.ItemProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class FetchAllCollectorItemsUsecase implements FetchAllCollectorItems {
  private final CollectorProvider collectorProvider;
  private final ItemProvider itemProvider;

  @Override
  public Flux<Item> execute(final Long collectorId) {
    return collectorProvider.findById(collectorId)
        .flatMapMany(collector -> itemProvider.findAllByCollectorId(collector.getId()))
        .onErrorMap(CollectorNotFoundException.class,
            _ -> new NotFoundException(Collector.class, collectorId));
  }
}
