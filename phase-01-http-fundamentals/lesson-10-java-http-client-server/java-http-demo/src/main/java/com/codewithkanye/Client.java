
package com.codewithkanye;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    public static void main(String[] args) throws Exception {

        // Create HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/hello"))
                .GET()
                .build();

        // Send request and receive response
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        // Create POST request
        String message = "Hello Server!";
            
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/messages"))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();
            
        // Send POST request
        HttpResponse<String> postResponse = client.send(
                postRequest,
                HttpResponse.BodyHandlers.ofString()
        );

        // Create an invalid GET request
        HttpRequest invalidRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/messages"))
                .GET()
                .build();

        // Send GET request
        HttpResponse<String> invalidResponse = client.send(
            invalidRequest, HttpResponse.BodyHandlers.ofString()
        );
        
        // Display response
        System.out.println(
            "\nInvalid Request Status Code: " + invalidResponse.statusCode()
        );

        // Display POST response
        System.out.println("\nPOST Status Code: " + postResponse.statusCode());
        System.out.println("POST Response Body: " + postResponse.body());

        // Display response
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }
}
