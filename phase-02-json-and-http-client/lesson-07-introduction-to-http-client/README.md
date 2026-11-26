# Lesson 7: Introduction to Java HttpClient

## Overview

In this lesson, I learned how to use Java's built-in HTTP Client API to communicate with external servers.

Java HttpClient allows applications to send HTTP requests and receive HTTP responses. It was introduced in Java 11 and is available through the `java.net.http` package.

I also built a practical Java application that sends a GET request to an external API and displays the response.

## Learning Objectives

By completing this lesson, I can:

- Explain what an HTTP Client is.
- Identify the main classes in Java HttpClient.
- Create an HTTP Client using `HttpClient.newHttpClient()`.
- Build HTTP requests using `HttpRequest`.
- Send requests using `client.send()`.
- Read HTTP response status codes and response bodies.
- Understand the difference between synchronous and asynchronous requests.

## 1. What Is an HTTP Client?

An HTTP Client is a tool that allows an application to send HTTP requests to a server and receive HTTP responses.

For example, a Java application can use an HTTP Client to communicate with an external REST API.

## 2. Java HttpClient API

Java provides a built-in HTTP Client API in the `java.net.http` package.

It was introduced in Java 11.

The three main classes are:

| Class | Purpose |
|---|---|
| `HttpClient` | Sends HTTP requests |
| `HttpRequest` | Represents an HTTP request |
| `HttpResponse` | Represents the response received from a server |

No external dependency is required to use Java HttpClient.

## 3. Creating an HTTP Client

```java
HttpClient client = HttpClient.newHttpClient();
```

`HttpClient.newHttpClient()` creates an HTTP Client instance that can communicate with servers.

## 4. Creating an HTTP Request

```java
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com"))
        .GET()
        .build();
```

Explanation:

- `newBuilder()` starts building an HTTP request.
- `URI.create()` converts the URI string into a URI object.
- `.GET()` specifies the HTTP GET method.
- `.build()` creates the final `HttpRequest` object.

## 5. Sending an HTTP Request

```java
HttpResponse<String> response = client.send(
        request,
        HttpResponse.BodyHandlers.ofString()
);
```

- `client.send()` sends the request and waits for the response.
- `BodyHandlers.ofString()` reads the response body as a Java String.
- `HttpResponse<String>` represents the response, with its body represented as a String.

## 6. Reading the HTTP Response

```java
System.out.println(response.statusCode());
System.out.println(response.body());
```

Important methods:

| Method | Purpose |
|---|---|
| `response.statusCode()` | Returns the HTTP status code |
| `response.body()` | Returns the response body |

For example, status code `200` means the request was successful.

## 7. Synchronous vs Asynchronous Requests

### Synchronous

```java
client.send(request, HttpResponse.BodyHandlers.ofString());
```

- The application waits for the response.
- Execution is blocked until the response is received or the request fails.

### Asynchronous

```java
client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
```

- Returns a `CompletableFuture`.
- Allows the application to continue without waiting for the response immediately.
- We will explore this in Lesson 14.

## 8. Practical Project: External API Request

### API Used

JSONPlaceholder:

https://jsonplaceholder.typicode.com/posts/1

### Project Structure

```text
lesson-07-introduction-to-http-client/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── codewithkanye/
                    └── Main.java
```

### Main.java

```java
package com.codewithkanye;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
            throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://jsonplaceholder.typicode.com/posts/1"
                ))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("Status Code: " + response.statusCode());

        System.out.println("Response Body:");
        System.out.println(response.body());
    }
}
```

### Running the Application

Compile the project:

```powershell
mvn clean compile
```

Run the application:

```powershell
mvn exec:java "-Dexec.mainClass=com.codewithkanye.Main"
```

### Expected Output

```text
Status Code: 200

Response Body:
{
  "userId": 1,
  "id": 1,
  "title": "...",
  "body": "..."
}
```

The title and body contain the actual post returned by JSONPlaceholder.

## 9. Key Takeaways

- Java HttpClient is built into Java 11 and later.
- It is available in the `java.net.http` package.
- `HttpClient` sends requests.
- `HttpRequest` represents an outgoing request.
- `HttpResponse` represents the server's response.
- `client.send()` performs a synchronous request.
- `response.statusCode()` returns the HTTP status code.
- `response.body()` retrieves the response body.
- Java HttpClient can communicate with external REST APIs.

## 10. Assessment Results

| Assessment | Score |
|---|---:|
| Exercise A | 9/10 |
| Exercise B | 4/5 |
| Multiple Choice | 5/5 |
| **Total** | **18/20 (90%)** |

Practical implementation: Successful.

## 11. Progress Tracker

- [x] Understand HTTP Client
- [x] Learn Java HttpClient API
- [x] Create an HTTP Client
- [x] Build an HTTP request
- [x] Send a synchronous request
- [x] Read the HTTP response
- [x] Complete practical implementation
- [x] Pass lesson assessment

## Next Lesson

**Lesson 8: Sending GET Requests**

In the next lesson, I will explore GET requests in more detail, retrieve data from REST APIs, and learn how to work with API response data in Java.