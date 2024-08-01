package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result;

import lombok.Builder;

@Builder
public record PokemonTcgImageDTO(
    String logo,
    String symbol,
    String small) {
}
