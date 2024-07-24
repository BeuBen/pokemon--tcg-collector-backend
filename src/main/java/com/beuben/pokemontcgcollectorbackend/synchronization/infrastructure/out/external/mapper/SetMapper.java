package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.PokemonTcgSetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "SetApiMapper")
public interface SetMapper {

  @Mapping(source = "id", target = "code")
  @Mapping(target = "id", ignore = true)
  CardSet toDomain(PokemonTcgSetDTO dto);
}
