# Lesson 2: HTTP Requests and Responses

**Phase:** 1 — HTTP Fundamentals and Networking  
**Status:** Completed  
**Assessment:** 5/5

## 1. Learning Objectives

By the end of this lesson, I can:

- Understand the structure of an HTTP request.
- Identify HTTP request methods and request targets.
- Understand HTTP request headers and bodies.
- Understand the structure of an HTTP response.
- Identify HTTP status codes.
- Explain the difference between `Content-Type` and `Accept`.

## 2. What Is an HTTP Request?

An HTTP request is a message sent by a client to a server asking it to perform an action or provide a resource.

Examples:
- A browser requesting a webpage.
- An application requesting a list of products.
- A client sending information to create a new product.

### Anatomy of an HTTP Request

An HTTP request has three main parts:

1. Request line
2. Headers
3. Message body (optional)

Example:

```http
POST /api/products HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{
    "name": "iPhone 15",
    "price": 650000,
    "quantity": 15
}
```

## 3. Request Line

The request line contains three parts:

```http
POST /api/products HTTP/1.1
```

| Part | Meaning |
|---|---|
| POST | HTTP method |
| /api/products | Request target |
| HTTP/1.1 | HTTP version |

**HTTP method:** Describes the action the client wants to perform.

**Request target:** Identifies the resource or endpoint being requested.

**HTTP version:** Indicates the HTTP protocol version being used.

## 4. HTTP Request Headers

Headers provide additional information about the request.

Example:

```http
Host: localhost:8080
Content-Type: application/json
Accept: application/json
```

Common headers:

| Header | Purpose |
|---|---|
| Host | Identifies the target host |
| Content-Type | Describes the format of the request body |
| Accept | Indicates the response formats the client can accept |
| Authorization | Carries authentication credentials or tokens |
| User-Agent | Identifies the client software |
| Cookie | Sends stored cookies to the server |

### Content-Type vs Accept

**Content-Type**

Tells the server the format of the data being sent.

Example:

```http
Content-Type: application/json
```

**Accept**

Tells the server which response format the client prefers or can accept.

Example:

```http
Accept: application/json
```

Remember:

- Content-Type = format of the content being sent.
- Accept = format of the response the client can accept.

## 5. HTTP Request Body

The request body contains the actual data being sent by the client.

Example:

```json
{
    "name": "Samsung S24",
    "price": 750000,
    "quantity": 10
}
```

Important points:

- GET requests commonly have no request body.
- POST requests commonly carry a request body.
- PUT and PATCH requests commonly carry data describing the requested update.
- The blank line after the headers separates the headers from the message body.

Not every HTTP request needs a body.

## 6. What Is an HTTP Response?

An HTTP response is a message sent by a server back to a client after processing its request.

An HTTP response has three main parts:

1. Status line
2. Headers
3. Message body (optional)

Example:

```http
HTTP/1.1 201 Created
Content-Type: application/json

{
    "id": 5,
    "name": "iPhone 15",
    "price": 650000,
    "quantity": 15
}
```

## 7. HTTP Status Line

The status line contains:

- HTTP version
- Status code
- Reason phrase

Example:

```http
HTTP/1.1 201 Created
```

| Part | Meaning |
|---|---|
| HTTP/1.1 | HTTP version |
| 201 | Status code |
| Created | Reason phrase |

### Important HTTP Status Codes

| Code | Meaning | Explanation |
|---|---|---|
| 200 | OK | Request succeeded |
| 201 | Created | A resource was successfully created |
| 400 | Bad Request | The request contains invalid information |
| 401 | Unauthorized | Authentication is required or invalid |
| 404 | Not Found | The requested resource was not found |
| 500 | Internal Server Error | Something went wrong on the server |

## 8. Response Headers and Body

Response headers provide information about the server's response.

Example:

```http
Content-Type: application/json
```

The response body contains the result or information returned by the server.

Example:

```json
{
    "message": "Product not found"
}
```

In this example, the server returns a JSON object containing a `message` property.

## 9. Request vs Response

| HTTP Request | HTTP Response |
|---|---|
| Sent by the client | Sent by the server |
| Contains a request line | Contains a status line |
| May contain request headers | May contain response headers |
| May contain a request body | May contain a response body |
| Asks the server to perform an action | Communicates the result |

## 10. Connection to Java Backend Development

In a Java backend application, a client might send JSON to an API.

For example:

```json
{
    "name": "iPhone 15",
    "price": 650000,
    "quantity": 15
}
```

A Java backend can represent this data using a record:

```java
public record ProductRequest(
    String name,
    BigDecimal price,
    int quantity
) {}
```

In a future lesson, we will explore how JSON data is converted into Java objects using a JSON library such as Jackson.

## 11. Common Mistakes to Avoid

1. Confusing `Content-Type` with `Accept`.
2. Assuming every HTTP request has a body.
3. Confusing request bodies with response bodies.
4. Confusing the request target with the HTTP method.
5. Forgetting that the blank line separates headers from the body.
6. Treating a status code and its reason phrase as the same thing.

## 12. Practical Exercises

### Exercise A: Analyze an HTTP Request

Given:

```http
POST /api/products HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{
    "name": "Samsung S24",
    "price": 750000,
    "quantity": 10
}
```

Key observations:

- Method: POST
- Request target: `/api/products`
- Server port: 8080
- Request body format: JSON
- Preferred response format: JSON
- Request body: Samsung S24 product information

### Exercise B: Analyze an HTTP Response

Given:

```http
HTTP/1.1 404 Not Found
Content-Type: application/json

{
    "message": "Product not found"
}
```

Key observations:

- HTTP version: HTTP/1.1
- Status code: 404
- Meaning: Requested resource was not found
- Response format: JSON
- Response body: An object containing the message `"Product not found"`

## 13. Knowledge Check

**Result: 5/5 — 100%**

Topics tested:

- Request target
- Content-Type
- Header/body separator
- HTTP 201 Created
- Client and server communication

## 14. Lesson Summary

In this lesson, I learned that HTTP communication involves requests and responses.

A client sends an HTTP request to a server. The server processes that request and sends an HTTP response.

I can now identify the main parts of both messages and understand how headers, bodies, and status codes work.

**Next Lesson:** Lesson 3 — HTTP Methods

**Progress:** 2 lessons completed in Phase 1.