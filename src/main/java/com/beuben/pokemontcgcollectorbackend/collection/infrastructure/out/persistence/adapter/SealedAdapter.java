package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.SealedProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.SealedMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.SealedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class SealedAdapter implements SealedProvider {
  private final SealedRepository repository;
  private final SealedMapper mapper;

  @Override
  public Flux<Sealed> findAllByCollectorId(Long collectorId) {
    return repository.findAllByCollectorId(collectorId)
        .map(mapper::toDomain);
  }
}
