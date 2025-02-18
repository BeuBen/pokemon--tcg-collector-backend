package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.MasterSetEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "MasterSetPersistenceMapper")
public interface MasterSetMapper {

  @Mapping(target = "estimation.priceInEuros", source = "estimationEuros")
  @Mapping(target = "estimation.date", source = "estimationDate")
  @Mapping(target = "estimation.sourceUrl", source = "estimationSourceUrl")
  MasterSet toDomain(MasterSetEntity entity);

  @Mapping(target = "estimationEuros", source = "estimation.priceInEuros")
  @Mapping(target = "estimationDate", source = "estimation.date")
  @Mapping(target = "estimationSourceUrl", source = "estimation.sourceUrl")
  MasterSetEntity toEntity(MasterSet domain);
}
