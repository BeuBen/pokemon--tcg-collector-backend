package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto;

public record PokemonTcgSetDTO(
    String id,
    String name,
    String series,
    Integer total,
    String releaseDate,
    PokemonTcgImageWrapperDTO images) {
}
