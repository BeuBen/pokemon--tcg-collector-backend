package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchMasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.MasterSetDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.MasterSetMapper;
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

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.MASTER_SET;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MasterSetController {
  private final FetchMasterSet fetchMasterSet;
  private final MasterSetMapper masterSetMapper;

  @Operation(
      summary = "Fetch master set",
      description = "Fetch master set by id",
      tags = {"Master Set"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Master set found successfully",
              content = {@Content(schema = @Schema(implementation = MasterSetDTO.class))}),
          @ApiResponse(
              responseCode = "404",
              description = "Master set not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(MASTER_SET)
  public Mono<ResponseEntity<MasterSetDTO>> findMasterSetById(@PathVariable final Long id) {
    return fetchMasterSet.execute(id)
        .map(masterSetMapper::toDTO)
        .map(ResponseEntity::ok);
  }
}
