package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.update;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update.UpdateMasterSetEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.MasterSetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.MasterSetNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UpdateMasterSetEstimationUsecase implements UpdateMasterSetEstimation {
  private final MasterSetProvider provider;

  @Override
  public Mono<MasterSet> execute(Long id, Estimation estimation) {
    final var now = LocalDateTime.now();
    final var datedEstimation = estimation.withDate(now);

    return provider.findById(id)
        .flatMap(masterSet ->
            provider.update(masterSet.withEstimation(datedEstimation)))
        .onErrorMap(MasterSetNotFoundException.class,
            _ -> new NotFoundException(MasterSet.class, id));
  }
}
