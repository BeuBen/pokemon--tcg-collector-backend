package com.beuben.pokemontcgcollectorbackend.core.exception.dto;

import java.time.LocalDateTime;

public record ErrorDTO(
    LocalDateTime date,
    String message) {
}
