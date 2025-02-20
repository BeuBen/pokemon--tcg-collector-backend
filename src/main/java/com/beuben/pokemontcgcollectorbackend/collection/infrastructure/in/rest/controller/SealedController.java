package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchSealed;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update.UpdateSealedEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.UpdateItemEstimationCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.SealedDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.EstimationMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.SealedMapper;
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

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.SEALED;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SealedController {
  private final FetchSealed fetchSealed;
  private final UpdateSealedEstimation updateSealedEstimation;
  private final SealedMapper sealedMapper;
  private final EstimationMapper estimationMapper;

  @Operation(
      summary = "Fetch sealed",
      description = "Fetch sealed by id",
      tags = {"Sealed"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Sealed found successfully",
              content = {@Content(schema = @Schema(implementation = SealedDTO.class))}),
          @ApiResponse(
              responseCode = "404",
              description = "Sealed not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(SEALED)
  public Mono<ResponseEntity<SealedDTO>> findSealedById(@PathVariable final Long id) {
    return fetchSealed.execute(id)
        .map(sealedMapper::toDTO)
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Update sealed estimation",
      description = "Update sealed estimation",
      tags = {"Sealed"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Sealed estimation updated successfully",
              content = {@Content(schema = @Schema(implementation = SealedDTO.class))}),
          @ApiResponse(
              responseCode = "404",
              description = "Sealed not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @PatchMapping(SEALED)
  public Mono<ResponseEntity<SealedDTO>> updateSealedEstimation(
      @PathVariable final Long id,
      @RequestBody @Valid final UpdateItemEstimationCommand command) {
    final var estimation = estimationMapper.toDomain(command);

    return updateSealedEstimation.execute(id, estimation)
        .map(sealedMapper::toDTO)
        .map(ResponseEntity::ok);
  }
}
