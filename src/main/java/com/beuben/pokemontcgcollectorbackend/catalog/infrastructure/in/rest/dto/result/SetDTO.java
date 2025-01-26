package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.dto.result;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SetDTO(
    Long id,
    String code,
    String name,
    String series,
    Integer cardTotal,
    LocalDateTime releaseDate,
    String symbolImage,
    String logoImage) {
}
