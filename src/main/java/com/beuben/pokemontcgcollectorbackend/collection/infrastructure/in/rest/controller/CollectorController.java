package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchCollector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.COLLECTORS;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CollectorController {
  private final FetchCollector fetchCollector;

  @Operation(
      summary = "Get collector by username",
      description = "Get collector by username",
      tags = {"Collector"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Collector found successfully",
              content = @Content(schema = @Schema(implementation = Collector.class))),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTORS)
  public Mono<ResponseEntity<Collector>> findCollectorByUsername(@RequestParam final String username) {
    return fetchCollector.execute(username)
        .map(ResponseEntity::ok);
  }
}
