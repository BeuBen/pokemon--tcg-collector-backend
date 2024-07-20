package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper;

import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.synchronization.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.PokemonTcgCardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class, implementationName = "CardApiMapper")
public interface CardMapper {

  @Mapping(source = "id", target = "code")
  @Mapping(target = "id", ignore = true)
  Card toDomain(PokemonTcgCardDTO dto);
}
