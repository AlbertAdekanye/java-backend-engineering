# Lesson 5 — HTTP Headers and Message Bodies

**Phase:** 1 — HTTP Fundamentals and Networking  
**Status:** Completed

## 1. What are HTTP Headers?

HTTP headers provide additional information about an HTTP request or response.

They tell the receiver how to interpret or handle the message.

Example:

```http
POST /api/products HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json
Authorization: Bearer abc123

{
    "name": "iPhone 15",
    "price": 650000,
    "quantity": 15
}
```

## 2. Important HTTP Headers

| Header | Purpose |
|---|---|
| Host | Identifies the target host |
| Content-Type | Describes the format of the message body |
| Accept | Specifies acceptable response formats |
| Authorization | Carries authentication credentials |
| Cache-Control | Controls caching behavior |
| User-Agent | Identifies the client software |
| Content-Length | Indicates the body size in bytes |
| Location | Identifies a resource location, often after creation |

### Content-Type

Tells the receiver the format of the data being sent.

```http
Content-Type: application/json
```

### Accept

Tells the server which response format the client can accept.

```http
Accept: application/json
```

Remember:

- Content-Type = What format am I sending?
- Accept = What format do I want back?

### Authorization

Carries authentication credentials.

```http
Authorization: Bearer your-token-here
```

### Cache-Control

Provides instructions for caching.

```http
Cache-Control: no-store
```

`no-store` instructs caches not to store the response.

### User-Agent

Identifies the software making the request.

```http
User-Agent: Mozilla/5.0
```

## 3. Request Headers vs Response Headers

### Request Headers

Information sent from the client to the server.

Examples:
- Host
- Content-Type
- Accept
- Authorization

### Response Headers

Information sent from the server to the client.

Examples:
- Content-Type
- Location
- Cache-Control

## 4. HTTP Message Bodies

A message body contains the actual data being transferred.

### Request Body

Data sent by the client to the server.

```json
{
    "name": "iPhone 15",
    "price": 650000,
    "quantity": 15
}
```

### Response Body

Data returned by the server to the client.

```json
{
    "id": 5,
    "name": "iPhone 15",
    "price": 650000,
    "quantity": 15
}
```

Not every HTTP request or response needs a body. For example, a successful DELETE operation may return `204 No Content` without a response body.

## 5. Content-Length

Indicates the size of the message body in bytes.

```http
Content-Length: 85
```

It helps the receiver understand how much message-body data is being transferred. It is not required in every HTTP message.

## 6. Complete HTTP Response Example

```http
HTTP/1.1 201 Created
Content-Type: application/json
Location: /api/products/20
Cache-Control: no-store

{
    "id": 20,
    "name": "HP EliteBook",
    "price": 950000,
    "quantity": 8
}
```

Explanation:

- `201 Created`: Resource successfully created.
- `Content-Type`: Response contains JSON.
- `Location`: Identifies where the created product can be accessed.
- `Cache-Control: no-store`: Tells caches not to store the response.
- JSON object: Response body.

## 7. Important Concepts

- Headers provide metadata about HTTP messages.
- A request body carries data from the client to the server.
- A response body carries data from the server to the client.
- Content-Type describes the format being sent.
- Accept describes the formats the client can accept.
- Authorization carries credentials.
- Cache-Control controls caching behavior.
- Location can identify a newly created resource.

## 8. Knowledge Check

**First check:** 5/5

**Practical exercise:** 6/6

**Final exercise:** 5/5

**Total:** 16/16

## Lesson Summary

I understand how HTTP headers and message bodies work, how request headers differ from response headers, and how common headers such as Content-Type, Accept, Authorization, Cache-Control and Location are used in backend development.

Next lesson: HTTP Query Parameters and Path Variables.