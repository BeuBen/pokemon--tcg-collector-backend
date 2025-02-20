package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.update;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update.UpdateGoodiesEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GoodiesProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.GoodiesNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UpdateGoodiesEstimationUsecase implements UpdateGoodiesEstimation {
  private final GoodiesProvider provider;

  @Override
  public Mono<Goodies> execute(Long id, Estimation estimation) {
    final var now = LocalDateTime.now();
    final var datedEstimation = estimation.withDate(now);

    return provider.findById(id)
        .flatMap(goodies ->
            provider.update(goodies.withEstimation(datedEstimation)))
        .onErrorMap(GoodiesNotFoundException.class,
            _ -> new NotFoundException(Goodies.class, id));
  }
}
