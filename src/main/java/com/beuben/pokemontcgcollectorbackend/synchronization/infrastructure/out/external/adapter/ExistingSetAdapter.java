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
        .expand(responseWrapper -> {
          var totalCount = responseWrapper.totalCount();
          var pageSize = responseWrapper.pageSize();
          var totalPages = (int) Math.ceil((double) totalCount / pageSize);

          var currentPage = responseWrapper.page();

          if (currentPage < totalPages) {
            return pokemonTcgApi.findAllSets(currentPage + 1);
          } else {
            return Mono.empty();
          }
        });
  }
}
