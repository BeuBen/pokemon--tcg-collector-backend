package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.update;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update.UpdateSealedEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.SealedProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.SealedNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UpdateSealedEstimationUsecase implements UpdateSealedEstimation {
  private final SealedProvider provider;

  @Override
  public Mono<Sealed> execute(Long id, Estimation estimation) {
    final var now = LocalDateTime.now();
    final var datedEstimation = estimation.withDate(now);

    return provider.findById(id)
        .flatMap(sealedItem ->
            provider.update(sealedItem.withEstimation(datedEstimation)))
        .onErrorMap(SealedNotFoundException.class,
            _ -> new NotFoundException(Sealed.class, id));
  }
}
