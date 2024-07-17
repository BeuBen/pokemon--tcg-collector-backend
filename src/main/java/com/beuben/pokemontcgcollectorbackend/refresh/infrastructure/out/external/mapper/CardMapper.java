package com.beuben.pokemontcgcollectorbackend.refresh.infrastructure.out.external.mapper;

import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.refresh.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.refresh.infrastructure.out.external.dto.PokemonTcgCardDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class, implementationName = "CardApiMapper")
public interface CardMapper {
  Card toDomain(PokemonTcgCardDTO dto);
}
