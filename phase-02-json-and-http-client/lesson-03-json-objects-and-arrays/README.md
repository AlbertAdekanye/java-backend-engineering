
# Lesson 3: JSON Objects and Arrays

## Overview

This lesson explores JSON objects and arrays, how they are structured, and how to access their values.

Objects store information as key-value pairs, while arrays store ordered collections of values.

These structures are commonly used when REST APIs return individual records or collections of resources.

## Learning Objectives

By the end of this lesson, I should be able to:

- Understand JSON objects and their structure.
- Identify keys and values inside JSON objects.
- Understand JSON arrays.
- Access array elements using indexes.
- Understand that array indexes start at zero.
- Work with arrays of objects.
- Understand how JSON objects and arrays relate to Java classes and Lists.

## Topics Covered

- JSON Objects
- JSON Keys and Values
- Accessing Object Properties
- JSON Arrays
- Array Indexes
- Arrays of Objects
- Arrays with Different Data Types
- JSON Objects vs Arrays
- Java Objects and Lists

## 1. JSON Objects

A JSON object is a collection of key-value pairs enclosed in curly braces `{}`.

Example:

```json
{
  "id": 101,
  "name": "Albert",
  "email": "albert@example.com",
  "age": 24
}
```

Key concepts:

- A key identifies a piece of data.
- A value contains the actual data.
- A colon `:` separates a key from its value.
- A comma separates key-value pairs.
- JSON object keys must use double quotation marks.

### Accessing Object Values

Given:

```json
{
  "id": 1,
  "name": "MacBook Pro",
  "price": 2500000
}
```

Conceptual property access:

```text
product.name  → "MacBook Pro"
product.price → 2500000
```

## 2. JSON Arrays

A JSON array is an ordered collection of values enclosed in square brackets `[]`.

Example:

```json
{
  "skills": [
    "Java",
    "SQL",
    "Spring Boot",
    "Docker"
  ]
}
```

Arrays are useful for storing multiple records or values.

Examples include:

- Products
- Users
- Orders
- Students
- Transactions

## 3. Array Indexes

Array indexes start at zero.

Example:

```json
{
  "languages": [
    "Java",
    "JavaScript",
    "Python",
    "PHP"
  ]
}
```

| Index | Value |
|---|---|
| 0 | Java |
| 1 | JavaScript |
| 2 | Python |
| 3 | PHP |

Conceptual access:

```text
languages[0] → "Java"
languages[1] → "JavaScript"
languages[2] → "Python"
```

## 4. Arrays of Objects

An array can contain multiple JSON objects.

Example:

```json
{
  "products": [
    {
      "id": 1,
      "name": "iPhone 13",
      "price": 400000
    },
    {
      "id": 2,
      "name": "iPhone 15",
      "price": 650000
    },
    {
      "id": 3,
      "name": "Samsung S24",
      "price": 800000
    }
  ]
}
```

Important concepts:

- The outer curly braces define a JSON object.
- `products` is the key containing the collection.
- Square brackets define the array.
- Each object inside the array represents one product.

## 5. Arrays with Different Data Types

JSON arrays can contain different data types.

Example:

```json
{
  "data": [
    "Albert",
    24,
    true,
    null,
    {
      "country": "Nigeria"
    },
    [1, 2, 3]
  ]
}
```

An array can contain strings, numbers, booleans, null values, objects, and other arrays.

## 6. JSON Object vs JSON Array

| Feature | Object | Array |
|---|---|---|
| Symbols | `{}` | `[]` |
| Structure | Key-value pairs | Ordered values |
| Access | By key | By index |
| Common use | Individual record | Collection of records |

## 7. JSON and Java

Java provides classes, arrays, and collections that can represent JSON structures.

| JSON Structure | Java Equivalent |
|---|---|
| JSON Object | Java class/object |
| JSON Array | Java array/List |
| Object property | Class field |
| Array element | List element |

Example Java class:

```java
public class User {

    private String name;
    private int age;

}
```

A collection of users can be represented using:

```java
List<User> users;
```

Jackson will later help us convert JSON into Java objects and Java objects into JSON.

## Practical Exercise

Given this JSON:

```json
{
  "store": "CodeWithKanye Store",
  "location": "Lagos",
  "products": [
    {
      "id": 1,
      "name": "MacBook Pro",
      "price": 2500000,
      "inStock": true
    },
    {
      "id": 2,
      "name": "iPhone 15",
      "price": 650000,
      "inStock": false
    },
    {
      "id": 3,
      "name": "Samsung S24",
      "price": 800000,
      "inStock": true
    }
  ]
}
```

Tasks:

1. Identify the key containing the product collection.
2. Identify the data type of products.
3. Count the product objects inside the array.
4. Identify the product name at index 0.
5. Identify the price at index 1.
6. Identify the inStock value for iPhone 15.
7. Identify the index of Samsung S24.
8. Identify the symbols used for JSON objects.
9. Identify the symbols used for JSON arrays.
10. Write the Java List declaration for a collection of Product objects.

## Knowledge Check Results

- [x] Quiz completed
- [x] Score: 5/5 (100%)
- [x] Lesson completed

## Practical Exercise Results

- [x] Exercise completed
- [x] Score: 7/10

## Important Concepts Learned

- Objects use curly braces `{}`.
- Arrays use square brackets `[]`.
- Objects contain key-value pairs.
- Arrays contain ordered values.
- Array indexes start at zero.
- Arrays can contain multiple objects.
- Java Lists can represent collections of objects.

## Lesson Status

**Completed**

## Next Lesson

Lesson 4: Working with Nested JSON
