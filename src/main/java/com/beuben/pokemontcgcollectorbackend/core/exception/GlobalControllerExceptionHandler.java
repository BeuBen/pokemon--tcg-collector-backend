package com.beuben.pokemontcgcollectorbackend.core.exception;

import com.beuben.pokemontcgcollectorbackend.core.exception.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorDTO> handleBusinessException(BusinessException exception) {
    var errorDetails = new ErrorDTO(LocalDateTime.now(), exception.getMessage());

    var httpStatus = exception.getHttpStatus();

    if (httpStatus.is4xxClientError()) {
      LOGGER.warn(exception.getMessage());
    } else if (httpStatus.is5xxServerError()) {
      LOGGER.error(exception.getMessage(), exception);
    }

    return ResponseEntity
        .status(httpStatus)
        .body(errorDetails);
  }
}
