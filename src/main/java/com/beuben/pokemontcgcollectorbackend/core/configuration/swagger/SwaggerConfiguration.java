package com.beuben.pokemontcgcollectorbackend.core.configuration.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.beuben.pokemontcgcollectorbackend.core.util.Constants.*;

@Configuration
public class SwaggerConfiguration {

  @Bean
  GroupedOpenApi actuator() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_ACTUATOR)
        .pathsToMatch(SWAGGER_PATH_ACTUATOR)
        .build();
  }

  @Bean
  GroupedOpenApi synchronization() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_SYNCHRO)
        .pathsToMatch(SWAGGER_PATH_SYNCHRO)
        .build();
  }

  @Bean
  GroupedOpenApi collection() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_COLLECTION)
        .pathsToMatch(SWAGGER_PATH_COLLECTION)
        .build();
  }
}
