package com.beuben.pokemontcgcollectorbackend.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends Exception {
  private final HttpStatus httpStatus;

  public BusinessException(String message, HttpStatus status) {
    super(message);
    this.httpStatus = status;
  }
}
