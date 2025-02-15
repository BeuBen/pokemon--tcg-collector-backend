package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.MasterSetEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MasterSetRepository extends ReactiveCrudRepository<MasterSetEntity, Long> {
  Flux<MasterSetEntity> findAllByCollectorId(Long collectorId);
}
