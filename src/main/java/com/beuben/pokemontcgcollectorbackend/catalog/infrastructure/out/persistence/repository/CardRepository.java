package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity.CardEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CardRepository extends ReactiveCrudRepository<CardEntity, Long> {
}
