package com.beuben.pokemontcgcollectorbackend.core.util;

public class Constants {
  //HTTP
  public static final String HTTP_HEADER_API_KEY = "X-Api-Key";
  public static final Integer HTTP_MAX_IN_MEMORY_SIZE = 16*1024*1024;

  //SWAGGER
  public static final String SWAGGER_GROUP_UPDATE_DATA = "Update data";
  public static final String SWAGGER_PATH_UPDATE_DATA = "/**/update-data/**";

  private Constants() {}
}
