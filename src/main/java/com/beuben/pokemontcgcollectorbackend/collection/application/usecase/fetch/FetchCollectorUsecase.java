package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchCollector;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.CollectorProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FetchCollectorUsecase implements FetchCollector {
  private final CollectorProvider provider;

  @Override
  public Mono<Collector> execute(final String username) {
    return provider.findByUsername(username)
        .onErrorMap(CollectorNotFoundException.class,
            _ -> new NotFoundException(Collector.class, username));
  }
}
