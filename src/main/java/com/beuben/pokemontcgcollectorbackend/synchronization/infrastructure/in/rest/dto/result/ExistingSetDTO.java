package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ExistingSetDTO(
    Long id,
    String code,
    String name,
    String series,
    Integer cardTotal,
    LocalDateTime releaseDate,
    String symbolImage,
    String logoImage) {
}
