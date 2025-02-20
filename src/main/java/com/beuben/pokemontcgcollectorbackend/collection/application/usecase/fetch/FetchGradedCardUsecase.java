package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchGradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GradedCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.GradedCardNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FetchGradedCardUsecase implements FetchGradedCard {
  private final GradedCardProvider provider;

  @Override
  public Mono<GradedCard> execute(Long id) {
    return provider.findById(id)
        .onErrorMap(GradedCardNotFoundException.class,
            _ -> new NotFoundException(GradedCard.class, id));
  }
}
