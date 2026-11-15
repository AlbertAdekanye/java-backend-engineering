# Lesson 6 — HTTP Query Parameters and Path Variables

**Phase:** 1 — HTTP Fundamentals and Networking  
**Status:** Completed

## 1. Understanding URL Structure

Example:

```http
https://localhost:8080/api/products/15?category=phones
```

| Part | Meaning |
|---|---|
| `https` | Protocol |
| `localhost` | Host |
| `8080` | Port |
| `/api/products/15` | URL path |
| `?category=phones` | Query parameter |

## 2. Path Variables

A path variable identifies a specific resource.

Example:

```http
GET /api/products/15
```

Here, `15` is the product ID.

### Spring Boot Example

```java
@GetMapping("/api/products/{id}")
public Product getProduct(@PathVariable Long id) {
    return productService.findById(id);
}
```

Explanation:

- `{id}` is a placeholder in the URL.
- `@PathVariable` extracts the value from the URL.
- `Long id` stores the extracted value.

For `/api/products/15`, Spring Boot passes `15` into the method.

## 3. Query Parameters

Query parameters are used to filter, search, sort, or control API results.

Example:

```http
GET /api/products?category=phones
```

This requests products belonging to the phones category.

Multiple query parameters:

```http
GET /api/products?minPrice=100000&maxPrice=500000
```

Important rules:

- Query parameters start with `?`.
- Multiple parameters are separated by `&`.
- Each parameter follows `key=value`.

Other examples:

```http
GET /api/products?search=iphone
GET /api/products?sortBy=price
GET /api/products?page=1&size=10
```

### Spring Boot Example

```java
@GetMapping("/api/products")
public List<Product> getProducts(
    @RequestParam String category
) {
    return productService.findByCategory(category);
}
```

`@RequestParam` extracts a query parameter from the URL.

### Optional Query Parameters

```java
@GetMapping("/api/products")
public List<Product> getProducts(
    @RequestParam(required = false) String category
) {
    return productService.findProducts(category);
}
```

If the user doesn't provide a category, its value will be `null`.

## 4. Path Variables vs Query Parameters

| Path Variable | Query Parameter |
|---|---|
| Identifies a resource | Filters or controls results |
| Part of the URL path | Appears after `?` |
| Uses `@PathVariable` | Uses `@RequestParam` |
| `/api/products/15` | `/api/products?category=phones` |

They can also be combined:

```http
GET /api/products/15?includeHistory=true
```

This identifies product 15 and requests its stock history.

## 5. Inventory Management API Examples

| Requirement | Endpoint |
|---|---|
| Get all products | `GET /api/products` |
| Get product ID 5 | `GET /api/products/5` |
| Search iPhone products | `GET /api/products?search=iphone` |
| Products below a price | `GET /api/products?maxPrice=500000` |
| Get low-stock products | `GET /api/products?lowStock=true` |
| Get product stock history | `GET /api/products/5/movements` |
| Get page 3, 20 per page | `GET /api/products?page=3&size=20` |

## 6. Important Concepts

- Path variables identify specific resources.
- Query parameters filter, search, sort, and control results.
- `@PathVariable` extracts values from URL paths.
- `@RequestParam` extracts values from query strings.
- `?` begins the query string.
- `&` separates multiple query parameters.
- Query parameter names must match the API's design.

## 7. Knowledge Check Results

- First knowledge check: 5/6
- Practical exercise: Completed
- Final knowledge check: 4/4

## Lesson Summary

I understand how REST APIs use path variables to identify resources and query parameters to filter and control results. I also understand how Spring Boot uses `@PathVariable` and `@RequestParam` to extract URL values.

Next lesson: Cookies, Sessions and Stateless Communication.