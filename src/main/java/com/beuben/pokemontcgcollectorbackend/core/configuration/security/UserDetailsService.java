package com.beuben.pokemontcgcollectorbackend.core.configuration.security;

import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.CollectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.beuben.pokemontcgcollectorbackend.core.util.Constants.NOOP;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements ReactiveUserDetailsService {
  private final CollectorRepository collectorRepository;

  @Override
  public Mono<UserDetails> findByUsername(String username) {
    return collectorRepository.findByUsername(username)
        .map(collectorEntity ->
            User.withUsername(collectorEntity.getUsername())
                .password(NOOP + collectorEntity.getPassword())
                .roles("USER")
                .build());
  }
}
