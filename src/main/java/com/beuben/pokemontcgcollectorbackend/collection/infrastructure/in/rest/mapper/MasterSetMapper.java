package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddMasterSetCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.MasterSetDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "MasterSetRestMapper")
public interface MasterSetMapper {

  @Mapping(target = "estimation.priceInEuros", source = "command.estimationEuros")
  @Mapping(target = "estimation.sourceUrl", source = "command.estimationSourceUrl")
  MasterSet toDomain(AddMasterSetCommand command, Long collectorId);

  @Mapping(target = "cardSetId", source = "setId")
  MasterSetDTO toDTO(MasterSet masterSet);
}
