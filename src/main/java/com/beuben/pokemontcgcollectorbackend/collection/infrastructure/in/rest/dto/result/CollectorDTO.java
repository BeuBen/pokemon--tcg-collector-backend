package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import lombok.Builder;

@Builder
public record CollectorDTO(
    Long id,
    String username) {
}
