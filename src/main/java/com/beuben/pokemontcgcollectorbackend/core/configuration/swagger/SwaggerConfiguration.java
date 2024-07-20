package com.beuben.pokemontcgcollectorbackend.core.configuration.swagger;

import com.beuben.pokemontcgcollectorbackend.core.util.Constants;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

  @Bean
  GroupedOpenApi synchronization() {
    return GroupedOpenApi.builder()
        .group(Constants.SWAGGER_GROUP_SYNCHRO)
        .pathsToMatch(Constants.SWAGGER_PATH_SYNCHRO)
        .build();
  }
}
