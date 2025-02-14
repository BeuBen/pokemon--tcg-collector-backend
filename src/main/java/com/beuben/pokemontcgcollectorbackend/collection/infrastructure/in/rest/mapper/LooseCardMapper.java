package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddLooseCardCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.LooseCardDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "LooseCardRestMapper")
public interface LooseCardMapper {

  @Mapping(target = "estimation.priceInEuros", source = "command.estimationEuros")
  @Mapping(target = "estimation.sourceUrl", source = "command.estimationSourceUrl")
  LooseCard toDomain(AddLooseCardCommand command, Long collectorId);

  LooseCardDTO toDTO(LooseCard looseCard);
}
