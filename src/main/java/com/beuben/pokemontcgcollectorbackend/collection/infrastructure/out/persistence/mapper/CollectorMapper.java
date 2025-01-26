package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.CollectorEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "CollectorPersistenceMapper")
public interface CollectorMapper {
  Collector toDomain(CollectorEntity entity);
}
