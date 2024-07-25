package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result;

import java.util.List;

public record PokemonTcgSetWrapperDTO(
    List<PokemonTcgSetDTO> data,
    Integer page,
    Integer pageSize,
    Integer count,
    Integer totalCount) {
}
