package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchGoodies;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.GoodiesDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.GoodiesMapper;
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

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.GOODIES;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodiesController {
  private final FetchGoodies fetchGoodies;
  private final GoodiesMapper mapper;

  @Operation(
      summary = "Fetch goodies",
      description = "Fetch goodies by id",
      tags = {"Goodies"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Goodies found successfully",
              content = {@Content(schema = @Schema(implementation = GoodiesDTO.class))}),
          @ApiResponse(
              responseCode = "404",
              description = "Goodies not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(GOODIES)
  public Mono<ResponseEntity<GoodiesDTO>> findGoodiesById(@PathVariable final Long id) {
    return fetchGoodies.execute(id)
        .map(mapper::toDTO)
        .map(ResponseEntity::ok);
  }
}
