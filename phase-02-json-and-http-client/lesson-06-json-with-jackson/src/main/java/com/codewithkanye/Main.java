package com.codewithkanye;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String json = """
                {
                    "id": 2,
                    "name": "Samsung S24",
                    "price": 800000
                }
                """;

        // Convert JSON into a Java Product object
        Product product = mapper.readValue(json, Product.class);

        System.out.println("Product ID: " + product.getId());
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Price: " + product.getPrice());
    }
}