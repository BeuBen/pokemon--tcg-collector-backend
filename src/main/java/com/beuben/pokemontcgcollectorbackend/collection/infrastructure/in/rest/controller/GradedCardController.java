package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchGradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.GradedCardDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.GradedCardMapper;
import com.beuben.pokemontcgcollectorbackend.core.exception.dto.ErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.GRADED_CARD;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GradedCardController {
  private final FetchGradedCard fetchGradedCard;
  private final GradedCardMapper gradedCardMapper;

  @Operation(
      summary = "Fetch graded card",
      description = "Fetch graded card by id",
      tags = {"Graded Card"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Graded card found successfully",
              content = {@Content(schema = @Schema(implementation = GradedCardDTO.class))}),
          @ApiResponse(
              responseCode = "404",
              description = "Graded card not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(GRADED_CARD)
  public Mono<ResponseEntity<GradedCardDTO>> findGradedCardById(@PathVariable final Long id) {
    return fetchGradedCard.execute(id)
        .map(gradedCardMapper::toDTO)
        .map(ResponseEntity::ok);
  }
}
