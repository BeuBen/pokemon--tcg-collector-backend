package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.GoodiesEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "GoodiesPersistenceMapper")
public interface GoodiesMapper {

  @Mapping(target = "estimation.priceInEuros", source = "estimationEuros")
  @Mapping(target = "estimation.date", source = "estimationDate")
  @Mapping(target = "estimation.sourceUrl", source = "estimationSourceUrl")
  Goodies toDomain(GoodiesEntity entity);

  @Mapping(target = "estimationEuros", source = "estimation.priceInEuros")
  @Mapping(target = "estimationDate", source = "estimation.date")
  @Mapping(target = "estimationSourceUrl", source = "estimation.sourceUrl")
  GoodiesEntity toEntity(Goodies domain);
}
