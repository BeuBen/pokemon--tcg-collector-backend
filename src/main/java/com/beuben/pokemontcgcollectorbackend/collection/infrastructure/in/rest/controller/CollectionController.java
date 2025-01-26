package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchAllCollectorItems;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchCollector;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.CollectorDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.ItemDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.CollectorMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.ItemMapper;
import com.beuben.pokemontcgcollectorbackend.core.exception.dto.ErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.COLLECTORS;
import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.COLLECTOR_ITEMS;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CollectionController {
  private final FetchCollector fetchCollector;
  private final FetchAllCollectorItems fetchAllCollectorItems;
  private final CollectorMapper collectorMapper;
  private final ItemMapper itemMapper;

  @Operation(
      summary = "Get collector by username",
      description = "Get collector by username",
      tags = {"Collector"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Collector found successfully",
              content = @Content(schema = @Schema(implementation = CollectorDTO.class))),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTORS)
  public Mono<ResponseEntity<CollectorDTO>> findCollectorByUsername(@RequestParam final String username) {
    return fetchCollector.execute(username)
        .map(collectorMapper::toDto)
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Fetch all collector's items",
      description = "Fetch all collector's items from its username",
      tags = {"Collector"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of items fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = ItemDTO.class)))}),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTOR_ITEMS)
  public Mono<ResponseEntity<List<ItemDTO>>> findAllCollectorItems(@PathVariable("id") final Long collectorId) {
    return fetchAllCollectorItems.execute(collectorId)
        .map(itemMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }
}
