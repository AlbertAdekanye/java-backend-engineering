package com.codewithkanye;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args)
            throws IOException, InterruptedException {

        // 1. Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // 2. Build an HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://jsonplaceholder.typicode.com/posts/1"
                ))
                .GET()
                .build();

        // 3. Send the request and receive the response
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        // 4. Display the response
        System.out.println("Status Code: " + response.statusCode());

        System.out.println("Response Body:");
        System.out.println(response.body());
    }
}