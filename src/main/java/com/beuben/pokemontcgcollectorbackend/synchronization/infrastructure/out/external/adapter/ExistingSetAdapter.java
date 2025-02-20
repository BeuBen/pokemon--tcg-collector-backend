package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.adapter;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingSetProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApi;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgSetWrapperDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper.SetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApiParam.INITIAL_PAGE;

@Component
@RequiredArgsConstructor
public class ExistingSetAdapter implements ExistingSetProvider {
  private final PokemonTcgApi pokemonTcgApi;
  private final SetMapper mapper;

  @Override
  public Flux<CardSet> findAll() {
    return fetchAllPages()
        .flatMapIterable(PokemonTcgSetWrapperDTO::data)
        .map(mapper::toDomain);
  }

  private Flux<PokemonTcgSetWrapperDTO> fetchAllPages() {
    return pokemonTcgApi.findAllSets(INITIAL_PAGE)
        .flatMapMany(this::getRemainingPages);
  }

  private Flux<PokemonTcgSetWrapperDTO> getRemainingPages(PokemonTcgSetWrapperDTO firstPage) {
    final var totalCount = firstPage.totalCount();
    final var pageSize = firstPage.pageSize();
    final var totalPages = (int) Math.ceil((double) totalCount / pageSize);

    var allRemainingPagesMonos = getParallelMonos(totalPages);

    return Flux.concat(
        Mono.just(firstPage),
        Flux.merge(allRemainingPagesMonos));
  }

  private List<Mono<PokemonTcgSetWrapperDTO>> getParallelMonos(int totalPages) {
    return IntStream.rangeClosed(INITIAL_PAGE + 1, totalPages)
        .mapToObj(pokemonTcgApi::findAllSets)
        .toList();
  }
}
