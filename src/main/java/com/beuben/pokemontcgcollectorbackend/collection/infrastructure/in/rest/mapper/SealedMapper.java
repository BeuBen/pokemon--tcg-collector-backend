package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddSealedCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.SealedDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "SealedRestMapper")
public interface SealedMapper {

  @Mapping(target = "estimation.priceInEuros", source = "command.estimationEuros")
  @Mapping(target = "estimation.sourceUrl", source = "command.estimationSourceUrl")
  @Mapping(target = "protected", source = "command.hasProtection")
  Sealed toDomain(AddSealedCommand command, Long collectorId);

  @Mapping(target = "hasProtection", source = "protected")
  SealedDTO toDTO(Sealed sealed);
}
