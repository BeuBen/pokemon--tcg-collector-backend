package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.LooseCardEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "LooseCardPersistenceMapper")
public interface LooseCardMapper {

  @Mapping(target = "estimation.priceInEuros", source = "estimationEuros")
  @Mapping(target = "estimation.date", source = "estimationDate")
  @Mapping(target = "estimation.sourceUrl", source = "estimationSourceUrl")
  LooseCard toDomain(LooseCardEntity entity);

  @Mapping(target = "estimationEuros", source = "estimation.priceInEuros")
  @Mapping(target = "estimationDate", source = "estimation.date")
  @Mapping(target = "estimationSourceUrl", source = "estimation.sourceUrl")
  LooseCardEntity toEntity(LooseCard domain);
}
