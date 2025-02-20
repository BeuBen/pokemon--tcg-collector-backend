package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchGoodies;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GoodiesProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.GoodiesNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FetchGoodiesUsecase implements FetchGoodies {
  private final GoodiesProvider provider;

  @Override
  public Mono<Goodies> execute(Long id) {
    return provider.findById(id)
        .onErrorMap(GoodiesNotFoundException.class,
            _ -> new NotFoundException(Goodies.class, id));
  }
}
