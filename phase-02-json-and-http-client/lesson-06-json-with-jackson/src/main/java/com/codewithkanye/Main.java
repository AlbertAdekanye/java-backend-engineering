package com.codewithkanye;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {

        String json = """
            {
                "id": 1,
                "name": "Albert",
                "address": {
                    "city":"Lagos",
                    "country":"Nigeria"
                }
            }
        """;

        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(json, User.class);
        

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getAddress().getCity());
        System.out.println(user.getAddress().getCountry());
    }
}