package com.beuben.pokemontcgcollectorbackend.collection.application.usecase;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchLooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.LooseCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.LooseCardNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FetchLooseCardUsecase implements FetchLooseCard {
  private final LooseCardProvider provider;

  @Override
  public Mono<LooseCard> execute(Long id) {
    return provider.findById(id)
        .onErrorMap(LooseCardNotFoundException.class,
            _ -> new NotFoundException(LooseCard.class, id));
  }
}
