package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.dto.result;

import lombok.Builder;

@Builder
public record CardDTO(
    Long id,
    String code,
    String name,
    SetDTO set,
    String rarity,
    String number,
    String image) {
}
