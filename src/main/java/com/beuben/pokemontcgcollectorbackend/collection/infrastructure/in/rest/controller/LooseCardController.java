package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchLooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.LooseCardDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.LooseCardMapper;
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

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.LOOSE_CARD;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LooseCardController {
  private final FetchLooseCard fetchLooseCard;
  private final LooseCardMapper looseCardMapper;

  @Operation(
      summary = "Fetch loose card",
      description = "Fetch loose card by id",
      tags = {"Loose Card"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Loose card found successfully",
              content = {@Content(schema = @Schema(implementation = LooseCardDTO.class))}),
          @ApiResponse(
              responseCode = "404",
              description = "Loose card not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(LOOSE_CARD)
  public Mono<ResponseEntity<LooseCardDTO>> findLooseCardById(@PathVariable final Long id) {
    return fetchLooseCard.execute(id)
        .map(looseCardMapper::toDTO)
        .map(ResponseEntity::ok);
  }
}
