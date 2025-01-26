package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity.SetEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SetRepository extends ReactiveCrudRepository<SetEntity, Long> {
}
