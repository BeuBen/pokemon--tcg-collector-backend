package com.beuben.pokemontcgcollectorbackend.core.util;

public class Constants {
  //HTTP
  public static final String HTTP_HEADER_API_KEY = "X-Api-Key";
  public static final Integer HTTP_MAX_IN_MEMORY_SIZE = 16 * 1024 * 1024;

  //SWAGGER
  public static final String SWAGGER_GROUP_ACTUATOR = "Actuator";
  public static final String SWAGGER_GROUP_CATALOG = "Catalog";
  public static final String SWAGGER_GROUP_COLLECTION = "Collection";
  public static final String SWAGGER_GROUP_SYNCHRO = "Synchronization";
  public static final String SWAGGER_PATH_ACTUATOR = "/**/actuator/**";
  public static final String SWAGGER_PATH_CATALOG = "/**/catalog/**";
  public static final String SWAGGER_PATH_COLLECTION = "/**/collection/**";
  public static final String SWAGGER_PATH_SYNCHRO = "/**/synchronization/**";

  private Constants() {
  }
}
