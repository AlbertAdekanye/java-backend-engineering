# Lesson 4: HTTP Status Codes

**Phase:** 1 — HTTP Fundamentals and Networking  
**Status:** Completed  
**Assessment:** 8/8 (100%)

## 1. Learning Objectives

By the end of this lesson, I can:

- Explain what HTTP status codes are.
- Understand the five HTTP status code categories.
- Identify common success status codes.
- Understand client errors and server errors.
- Differentiate between 401 Unauthorized and 403 Forbidden.
- Select appropriate HTTP status codes for backend API responses.

## 2. What Are HTTP Status Codes?

HTTP status codes are three-digit numbers returned by a server to communicate the result of an HTTP request.

Example:

```http
HTTP/1.1 200 OK
```

This means the request was successful.

Another example:

```http
HTTP/1.1 404 Not Found
```

This means the requested resource could not be found.

## 3. The Five Categories of HTTP Status Codes

| Range | Category | Meaning |
|---|---|---|
| 100–199 | Informational | Request processing information |
| 200–299 | Success | Request succeeded |
| 300–399 | Redirection | Further action is needed |
| 400–499 | Client Errors | Problem with the request |
| 500–599 | Server Errors | Server failed to fulfil a valid request |

### 1xx — Informational

These codes provide information about the request process.

Example:

- `100 Continue` — The client can continue sending its request.

### 2xx — Success

These codes indicate successful requests.

| Code | Name | Meaning |
|---|---|---|
| 200 | OK | Request succeeded |
| 201 | Created | A new resource was created |
| 204 | No Content | Request succeeded with no response body |

### 3xx — Redirection

These codes indicate that further action is needed to complete the request.

| Code | Name | Meaning |
|---|---|---|
| 301 | Moved Permanently | Resource has a permanent new URL |
| 302 | Found | Resource is temporarily available at another URL |

### 4xx — Client Errors

These codes indicate a problem with the request or the client's access.

| Code | Name | Meaning |
|---|---|---|
| 400 | Bad Request | Invalid request information |
| 401 | Unauthorized | Authentication is missing or invalid |
| 403 | Forbidden | Client does not have permission |
| 404 | Not Found | Resource could not be found |
| 409 | Conflict | Request conflicts with the current resource state |
| 422 | Unprocessable Content | Request content cannot be processed |

### 5xx — Server Errors

These codes indicate that the server failed to fulfil a valid request.

| Code | Name | Meaning |
|---|---|---|
| 500 | Internal Server Error | Unexpected server-side error |
| 502 | Bad Gateway | Invalid response from an upstream server |
| 503 | Service Unavailable | Server is temporarily unavailable |

## 4. Understanding 401 vs 403

These two status codes are important in backend security.

**401 Unauthorized**

The client has not provided valid authentication credentials.

Example: A user tries to access an endpoint without logging in.

**403 Forbidden**

The client is authenticated but does not have permission to perform the requested action.

Example: A normal user tries to access an admin-only endpoint.

Remember:

- 401 = Who are you?
- 403 = You are identified, but are you allowed?

## 5. HTTP Status Codes in Inventory Management

| Scenario | Status Code |
|---|---|
| Successfully retrieve products | 200 OK |
| Successfully create a product | 201 Created |
| Successfully delete a product without returning a body | 204 No Content |
| Product name is missing | 400 Bad Request |
| User is not authenticated | 401 Unauthorized |
| User lacks permission | 403 Forbidden |
| Product ID does not exist | 404 Not Found |
| Duplicate SKU | 409 Conflict |
| Unexpected application error | 500 Internal Server Error |

## 6. Practical HTTP Response Examples

### Example A: Successful Product Creation

```http
HTTP/1.1 201 Created
Content-Type: application/json

{
    "id": 10,
    "name": "iPhone 16",
    "price": 900000,
    "quantity": 20
}
```

### Example B: Product Not Found

```http
HTTP/1.1 404 Not Found
Content-Type: application/json

{
    "message": "Product not found"
}
```

### Example C: Invalid Product Information

```http
HTTP/1.1 400 Bad Request
Content-Type: application/json

{
    "message": "Product price cannot be negative"
}
```

### Example D: Duplicate SKU

```http
HTTP/1.1 409 Conflict
Content-Type: application/json

{
    "message": "A product with this SKU already exists"
}
```

## 7. Important Backend Concepts

When building APIs, choosing the correct status code helps clients understand what happened.

For example:

- Return 200 when a request succeeds and returns a response.
- Return 201 when a resource is successfully created.
- Return 204 when a request succeeds without a response body.
- Return 400 when request information is invalid.
- Return 404 when a requested resource cannot be found.
- Return 500 for unexpected server-side failures.

## 8. Common Mistakes

1. Confusing 401 Unauthorized with 403 Forbidden.
2. Returning 200 for every successful operation instead of using more appropriate codes.
3. Returning 500 for errors caused by invalid client input.
4. Using 404 when a resource exists but the user lacks permission.
5. Returning 204 while also expecting the client to receive a response body.

## 9. Knowledge Check

**Result: 8/8 — 100%**

Topics tested:

- 200 OK
- 201 Created
- 401 Unauthorized
- 403 Forbidden
- 404 Not Found
- 204 No Content
- 409 Conflict
- 500 Internal Server Error

## 10. Lesson Summary

HTTP status codes communicate the outcome of client-server communication.

The five categories are:

- 1xx — Informational
- 2xx — Success
- 3xx — Redirection
- 4xx — Client Errors
- 5xx — Server Errors

Understanding these codes is essential for designing reliable REST APIs and handling errors correctly in Java backend applications.

**Next Lesson:** Lesson 5 — HTTP Headers and Message Bodies

**Progress:** 4 lessons completed in Phase 1.