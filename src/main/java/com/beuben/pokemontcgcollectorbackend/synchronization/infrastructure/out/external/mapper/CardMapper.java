package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgCardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "CardApiMapper",
    uses = SetMapper.class)
public interface CardMapper {

  @Mapping(source = "id", target = "code")
  @Mapping(target = "id", ignore = true)
  @Mapping(source = "images.small", target = "image")
  Card toDomain(PokemonTcgCardDTO dto);
}
