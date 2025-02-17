package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest;

public class Endpoints {
  public static final String COLLECTION = "/collection";
  public static final String COLLECTORS = "/collectors";
  public static final String COLLECTOR_GRADED_CARDS = "/collectors/{collectorId}/graded-cards";
  public static final String COLLECTOR_ITEMS = "/collectors/{collectorId}/items";
  public static final String COLLECTOR_LOOSE_CARDS = "/collectors/{collectorId}/loose-cards";

  public static final String GRADED_CARD = "/graded-cards/{id}";
  public static final String LOOSE_CARD = "/loose-cards/{id}";

  private Endpoints() {
  }
}
