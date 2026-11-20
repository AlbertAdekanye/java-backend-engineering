
package com.codewithkanye;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.net.InetSocketAddress;

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

        // Start server
        server.start();

        System.out.println(
                "Server running at http://localhost:8080"
        );
    }
}
