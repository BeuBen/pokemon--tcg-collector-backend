package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.update;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update.UpdateLooseCardEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.LooseCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.LooseCardNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UpdateLooseCardEstimationUsecase implements UpdateLooseCardEstimation {
  private final LooseCardProvider provider;

  @Override
  public Mono<LooseCard> execute(Long id, Estimation estimation) {
    final var now = LocalDateTime.now();
    final var datedEstimation = estimation.withDate(now);

    return provider.findById(id)
        .flatMap(looseCard ->
            provider.update(looseCard.withEstimation(datedEstimation)))
        .onErrorMap(LooseCardNotFoundException.class,
            _ -> new NotFoundException(LooseCard.class, id));
  }
}
