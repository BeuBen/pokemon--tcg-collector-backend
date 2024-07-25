package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result;

public record PokemonTcgCardDTO(
    String id,
    String name,
    PokemonTcgSetDTO set,
    String number,
    String rarity,
    PokemonTcgImageDTO images) {
}
