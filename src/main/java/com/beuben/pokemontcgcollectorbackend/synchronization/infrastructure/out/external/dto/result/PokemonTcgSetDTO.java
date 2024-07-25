package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result;

public record PokemonTcgSetDTO(
    String id,
    String name,
    String series,
    Integer total,
    String releaseDate,
    PokemonTcgImageDTO images) {
}
