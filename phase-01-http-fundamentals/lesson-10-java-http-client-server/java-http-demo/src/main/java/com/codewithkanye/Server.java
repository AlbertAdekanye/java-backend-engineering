package com.codewithkanye;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main(String[] args) throws IOException {

        // Create an HTTP server on port 8080
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0
        );

        // Create an endpoint
        server.createContext("/api/hello", exchange -> {

            String response = "Hello from Java HTTP Server!";

            // Set response content type
            exchange.getResponseHeaders().set(
                    "Content-Type", "text/plain; charset=UTF-8"
            );

            // Send HTTP 200 response
            exchange.sendResponseHeaders(
                    200, response.getBytes().length
            );

            // Send response body
            exchange.getResponseBody().write(
                    response.getBytes()
            );

            exchange.close();
        });

        server.createContext("/api/messages", exchange -> {

        if (!exchange.getRequestMethod().equals("POST")) {
        
            String response = "Method Not Allowed";
            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
        
            exchange.getResponseHeaders().set(
                    "Content-Type", "text/plain; charset=UTF-8"
            );
    
            exchange.sendResponseHeaders(405, responseBytes.length);
    
            try (var output = exchange.getResponseBody()) {
                output.write(responseBytes);
            }
    
            return;
        }

            // Read the message sent by the client
            String requestBody = new String(
                    exchange.getRequestBody().readAllBytes(),
                    StandardCharsets.UTF_8
            );

            // Prepare the response
            String response = "Server received: " + requestBody;

            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);

            // Set response content type
            exchange.getResponseHeaders().set(
                    "Content-Type", "text/plain; charset=UTF-8"
            );

            // Send HTTP 200 response
            exchange.sendResponseHeaders(200, responseBytes.length);

            // Send response body
            try (var output = exchange.getResponseBody()) {
                output.write(responseBytes);
            }
        });

        // Start server
        server.start();

        System.out.println(
                "Server running at http://localhost:8080"
        );
    }
}
