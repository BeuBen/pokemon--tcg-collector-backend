package com.beuben.pokemontcgcollectorbackend.core.util;

public class Constants {
  //HTTP
  public static final String HTTP_HEADER_API_KEY = "X-Api-Key";
  public static final Integer HTTP_MAX_IN_MEMORY_SIZE = 16 * 1024 * 1024;

  //SWAGGER
  public static final String SWAGGER_GROUP_ACTUATOR = "Actuator";
  public static final String SWAGGER_PATH_ACTUATOR = "/**/actuator/**";
  public static final String SWAGGER_GROUP_CATALOG = "Catalog";
  public static final String SWAGGER_PATH_CATALOG = "/**/catalog/**";
  public static final String SWAGGER_GROUP_COLLECTION = "Collection";
  public static final String SWAGGER_PATH_COLLECTION = "/**/collection/**";
  public static final String SWAGGER_GROUP_GOODIES = "Goodies";
  public static final String SWAGGER_PATH_GOODIES = "/**/goodies/**";
  public static final String SWAGGER_GROUP_GRADED_CARD = "Graded Card";
  public static final String SWAGGER_PATH_GRADED_CARD = "/**/graded-cards/**";
  public static final String SWAGGER_GROUP_LOOSE_CARD = "Loose Card";
  public static final String SWAGGER_PATH_LOOSE_CARD = "/**/loose-cards/**";
  public static final String SWAGGER_GROUP_MASTER_SET = "Master Set";
  public static final String SWAGGER_PATH_MASTER_SET = "/**/master-sets/**";
  public static final String SWAGGER_GROUP_SYNCHRO = "Synchronization";
  public static final String SWAGGER_PATH_SYNCHRO = "/**/synchronization/**";

  private Constants() {
  }
}
