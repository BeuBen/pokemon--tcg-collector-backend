package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddGoodiesCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.GoodiesDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "GoodiesRestMapper")
public interface GoodiesMapper {

  @Mapping(target = "estimation.priceInEuros", source = "command.estimationEuros")
  @Mapping(target = "estimation.sourceUrl", source = "command.estimationSourceUrl")
  Goodies toDomain(AddGoodiesCommand command, Long collectorId);

  GoodiesDTO toDTO(Goodies goodies);
}
