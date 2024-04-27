package com.beuben.pokemontcgcollectorbackend.core.configuration;

import com.beuben.pokemontcgcollectorbackend.core.util.Constants;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

  @Bean
  GroupedOpenApi updateDataApi() {
    return GroupedOpenApi.builder()
        .group(Constants.SWAGGER_GROUP_UPDATE_DATA)
        .pathsToMatch(Constants.SWAGGER_PATH_UPDATE_DATA)
        .build();
  }
}
