package com.beuben.pokemontcgcollectorbackend.core.configuration.swagger;

import com.beuben.pokemontcgcollectorbackend.core.util.Constants;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

  @Bean
  GroupedOpenApi actuator() {
    return GroupedOpenApi.builder()
        .group(Constants.SWAGGER_GROUP_ACTUATOR)
        .pathsToMatch(Constants.SWAGGER_PATH_ACTUATOR)
        .build();
  }

  @Bean
  GroupedOpenApi synchronization() {
    return GroupedOpenApi.builder()
        .group(Constants.SWAGGER_GROUP_SYNCHRO)
        .pathsToMatch(Constants.SWAGGER_PATH_SYNCHRO)
        .build();
  }
}
