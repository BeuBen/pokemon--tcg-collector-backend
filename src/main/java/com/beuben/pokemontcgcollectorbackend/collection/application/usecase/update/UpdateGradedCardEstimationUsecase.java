package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.update;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update.UpdateGradedCardEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GradedCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.GradedCardNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UpdateGradedCardEstimationUsecase implements UpdateGradedCardEstimation {
  private final GradedCardProvider provider;

  @Override
  public Mono<GradedCard> execute(Long id, Estimation estimation) {
    final var now = LocalDateTime.now();
    final var datedEstimation = estimation.withDate(now);

    return provider.findById(id)
        .flatMap(gradedCard ->
            provider.update(gradedCard.withEstimation(datedEstimation)))
        .onErrorMap(GradedCardNotFoundException.class,
            _ -> new NotFoundException(GradedCard.class, id));
  }
}
