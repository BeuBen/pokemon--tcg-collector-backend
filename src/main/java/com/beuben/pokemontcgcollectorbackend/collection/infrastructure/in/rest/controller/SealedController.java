package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchSealed;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.SealedDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.SealedMapper;
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

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.SEALED;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SealedController {
  private final FetchSealed fetchSealed;
  private final SealedMapper sealedMapper;

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
}
