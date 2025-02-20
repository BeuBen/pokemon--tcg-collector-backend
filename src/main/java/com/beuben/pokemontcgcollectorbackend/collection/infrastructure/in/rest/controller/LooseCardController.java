package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchLooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update.UpdateLooseCardEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.UpdateItemEstimationCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.LooseCardDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.EstimationMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.LooseCardMapper;
import com.beuben.pokemontcgcollectorbackend.core.exception.dto.ErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.LOOSE_CARD;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LooseCardController {
  private final FetchLooseCard fetchLooseCard;
  private final UpdateLooseCardEstimation updateLooseCardEstimation;
  private final LooseCardMapper looseCardMapper;
  private final EstimationMapper estimationMapper;

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

  @Operation(
      summary = "Update loose card estimation",
      description = "Update loose card estimation",
      tags = {"Loose Card"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Loose card estimation updated successfully",
              content = {@Content(schema = @Schema(implementation = LooseCardDTO.class))}),
          @ApiResponse(
              responseCode = "404",
              description = "Loose card not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @PatchMapping(LOOSE_CARD)
  public Mono<ResponseEntity<LooseCardDTO>> updateLooseCardEstimation(
      @PathVariable final Long id,
      @RequestBody @Valid final UpdateItemEstimationCommand command) {
    final var estimation = estimationMapper.toDomain(command);

    return updateLooseCardEstimation.execute(id, estimation)
        .map(looseCardMapper::toDTO)
        .map(ResponseEntity::ok);
  }
}
