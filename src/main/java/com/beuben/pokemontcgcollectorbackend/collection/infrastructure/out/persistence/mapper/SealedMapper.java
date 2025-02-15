package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.SealedEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "SealedPersistenceMapper")
public interface SealedMapper {

  @Mapping(target = "estimation.priceInEuros", source = "estimationEuros")
  @Mapping(target = "estimation.date", source = "estimationDate")
  @Mapping(target = "estimation.sourceUrl", source = "estimationSourceUrl")
  Sealed toDomain(SealedEntity entity);
}
