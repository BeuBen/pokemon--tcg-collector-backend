package com.beuben.pokemontcgcollectorbackend.core.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BusinessException {
  public NotFoundException(Class<?> entityType, Object entityId) {
    super(String.format("%s not found with id %s",
            entityType.getSimpleName(),
            entityId != null ? entityId.toString() : ""),
        HttpStatus.NOT_FOUND);
  }
}
