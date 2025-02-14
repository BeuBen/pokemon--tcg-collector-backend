package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest;

public class Endpoints {
  public static final String COLLECTORS = "/collection/collectors";
  public static final String COLLECTOR_ITEMS = "/collection/collectors/{id}/items";
  public static final String COLLECTOR_LOOSE_CARDS = "/collection/collectors/{collectorId}/loose-cards";

  private Endpoints() {
  }
}
