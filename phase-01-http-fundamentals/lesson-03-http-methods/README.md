# Lesson 3: HTTP Methods

**Phase:** 1 — HTTP Fundamentals and Networking  
**Status:** Completed  
**Assessment:** 3/3 + 4/4 + 4/5

## 1. Learning Objectives

By the end of this lesson, I can:

- Explain what HTTP methods are.
- Understand GET, POST, PUT, PATCH, and DELETE.
- Choose the appropriate HTTP method for an API operation.
- Understand the difference between PUT and PATCH.
- Explain idempotency.

## 2. What Are HTTP Methods?

HTTP methods tell a server what action a client wants to perform on a resource.

For example, an inventory API can use different methods to retrieve, create, update, or delete products.

## 3. GET — Retrieve Data

GET retrieves information from a server.

Examples:

```http
GET /api/products
GET /api/products/5
```

- The first retrieves all products.
- The second retrieves product ID 5.
- GET should not be used to change server data.

## 4. POST — Create Data

POST is commonly used to create a new resource.

Example:

```http
POST /api/products
Content-Type: application/json
```

Request body:

```json
{
    "name": "Samsung S24",
    "price": 750000,
    "quantity": 10
}
```

A successful creation commonly returns:

```http
HTTP/1.1 201 Created
```

## 5. PUT — Replace a Resource

PUT is used to replace an existing resource representation.

Example:

```http
PUT /api/products/5
Content-Type: application/json
```

Request body:

```json
{
    "name": "iPhone 16",
    "price": 900000,
    "quantity": 20
}
```

PUT generally sends the complete representation that should replace the existing resource.

## 6. PATCH — Partially Update a Resource

PATCH is used to apply partial changes to a resource.

Example:

```http
PATCH /api/products/5
Content-Type: application/json
```

Request body:

```json
{
    "price": 700000
}
```

Only the price is being changed. Other product details remain unchanged.

### PUT vs PATCH

| PUT | PATCH |
|---|---|
| Replaces the resource representation | Applies partial changes |
| Usually sends the complete representation | Usually sends only changed fields |
| Used for full replacement | Used for partial updates |

## 7. DELETE — Remove a Resource

DELETE requests the removal of a resource.

Example:

```http
DELETE /api/products/5
```

A successful response might be:

```http
HTTP/1.1 204 No Content
```

This means the deletion succeeded and the response has no body.

## 8. Idempotency

An operation is idempotent when repeating the same request has the same intended effect as performing it once.

For example, deleting product ID 5 repeatedly should leave that product deleted.

| HTTP Method | Idempotent? |
|---|---|
| GET | Yes |
| POST | Generally no |
| PUT | Yes |
| PATCH | Depends on the operation |
| DELETE | Yes |

Note: Idempotency concerns the intended effect on server state, not necessarily identical response codes.

## 9. HTTP Methods in Inventory Management

| Operation | Method | Endpoint |
|---|---|---|
| View all products | GET | `/api/products` |
| View one product | GET | `/api/products/5` |
| Add a product | POST | `/api/products` |
| Replace product details | PUT | `/api/products/5` |
| Change product price | PATCH | `/api/products/5` |
| Delete a product | DELETE | `/api/products/5` |

## 10. Common Mistakes

1. Using PUT when POST is appropriate for creating a new resource.
2. Confusing PUT and PATCH.
3. Using GET to modify server data.
4. Assuming every PATCH request is idempotent.
5. Assuming DELETE must always return the same response when repeated.

## 11. Knowledge Check

- First quiz: 3/3
- Second quiz: 4/4
- Practical exercise: 5/5

The main correction was remembering that POST is commonly used to create a new product, while PUT is used to replace an existing resource.

## 12. Lesson Summary

HTTP methods describe the action a client wants a server to perform.

The five important methods are:

- GET — Retrieve
- POST — Create
- PUT — Replace
- PATCH — Partially update
- DELETE — Remove

**Next Lesson:** Lesson 4 — HTTP Status Codes

**Progress:** 3 lessons completed in Phase 1.