package com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.out.external.mapper;

import com.beuben.pokemontcgcollectorbackend.updatedata.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.out.external.dto.PokemonTcgCardDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = "spring",
    implementationName = "CardApiMapper")
public interface CardMapper {
  Card toDomain(PokemonTcgCardDTO dto);
}
