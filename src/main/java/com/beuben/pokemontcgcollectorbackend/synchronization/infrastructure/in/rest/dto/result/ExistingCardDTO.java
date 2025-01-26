package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result;

import lombok.Builder;

@Builder
public record ExistingCardDTO(
    Long id,
    String code,
    String name,
    ExistingSetDTO set,
    String rarity,
    String number,
    String image) {
}
