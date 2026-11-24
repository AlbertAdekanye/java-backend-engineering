package com.codewithkanye;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

  public static void main(String[] args) throws Exception {

    // Create a Product object
    Product product = new Product(
      1,
      "iphone 15",
      650000
    );

    // create ObjectMapper
    ObjectMapper mapper = new ObjectMapper();

    // Convert Java object to JSON
    String json = mapper.writeValueAsString(product);

    // Print JSON
    System.out.println(json);
  }
}