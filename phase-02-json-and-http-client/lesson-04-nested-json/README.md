
# Lesson 4: Working with Nested JSON

## Overview

This lesson covers how to read, understand, and navigate nested JSON structures.

Nested JSON is common in REST API responses because real-world data often contains objects inside objects and arrays inside objects.

## Learning Objectives

By the end of this lesson, I can:

- [x] Understand what nested JSON means.
- [x] Identify nested objects.
- [x] Identify arrays inside objects.
- [x] Identify objects inside arrays.
- [x] Access nested values using dot notation.
- [x] Access array elements using indexes.
- [x] Understand how nested JSON maps to Java classes.

## 1. What Is Nested JSON?

Nested JSON occurs when a JSON object or array is placed inside another JSON object or array.

Example:

```json
{
  "name": "Albert",
  "address": {
    "city": "Lagos",
    "country": "Nigeria"
  }
}
```

The `address` property contains another JSON object.

This is called a nested object.

## 2. Accessing Nested Objects

You can access nested properties using dot notation.

Example:

```json
{
  "user": {
    "name": "Albert",
    "address": {
      "city": "Lagos"
    }
  }
}
```

To access the city:

```javascript
user.address.city
```

Result:

```text
Lagos
```

## 3. Arrays Inside Objects

A JSON object can contain an array.

Example:

```json
{
  "name": "Albert",
  "skills": [
    "Java",
    "SQL",
    "Spring Boot"
  ]
}
```

Accessing array elements:

```javascript
user.skills[0]
```

Result:

```text
Java
```

Remember: Array indexes start at zero.

| Index | Value |
|---|---|
| 0 | Java |
| 1 | SQL |
| 2 | Spring Boot |

## 4. Objects Inside Arrays

An array can contain multiple JSON objects.

Example:

```json
{
  "products": [
    {
      "id": 1,
      "name": "iPhone 13"
    },
    {
      "id": 2,
      "name": "iPhone 15"
    }
  ]
}
```

Accessing the second product's name:

```javascript
products[1].name
```

Result:

```text
iPhone 15
```

## 5. Combining Nested Objects and Arrays

Real-world API responses often combine nested objects and arrays.

Example:

```json
{
  "orderId": 101,
  "customer": {
    "name": "Albert",
    "address": {
      "city": "Lagos",
      "country": "Nigeria"
    }
  },
  "items": [
    {
      "product": "MacBook Pro",
      "quantity": 1
    },
    {
      "product": "iPhone 15",
      "quantity": 2
    }
  ],
  "paid": true
}
```

Examples of accessing values:

```javascript
order.customer.name
```

Result: Albert

```javascript
order.customer.address.city
```

Result: Lagos

```javascript
order.items[0].product
```

Result: MacBook Pro

```javascript
order.items[1].quantity
```

Result: 2

## 6. How Java Represents Nested JSON

Java uses classes and objects to represent JSON structures.

For example, the nested address object can be represented using a separate Java class.

```java
public class Address {
    private String city;
    private String country;
}
```

The user class can contain an Address object:

```java
public class User {
    private String name;
    private Address address;
}
```

This is an example of composition: one class contains an object of another class.

Arrays of JSON objects can also be represented using Java collections such as:

```java
List<Product> products;
```

We will explore converting JSON into Java objects in the upcoming serialization and deserialization lessons.

## Important Concepts

| Concept | Meaning |
|---|---|
| Nested JSON | JSON inside another JSON structure |
| Nested object | An object inside another object |
| Array inside object | An array stored as an object property |
| Object inside array | An object stored as an array element |
| Dot notation | Accessing nested object properties |
| Array index | Position of an element, starting at zero |
| Composition | A class containing an object of another class |

## Practical Exercise Results

Score: **8/10**

Topics tested:

- Identifying nested objects.
- Identifying arrays.
- Accessing nested properties.
- Navigating arrays of objects.
- Understanding JSON values and data types.

Areas to improve:

- Distinguishing a property value from its data type.
- Identifying the correct property when navigating nested objects.

## Knowledge Check Results

Score: **5/5**

All five quiz questions answered correctly.

## Lesson Status

- [x] Lesson completed
- [x] Practical exercise completed
- [x] Knowledge check completed
- [x] README documentation completed

## Next Lesson

**Lesson 5: JSON Serialization and Deserialization**

Topics:

- What serialization means.
- What deserialization means.
- Converting Java objects into JSON.
- Converting JSON into Java objects.
- Why serialization and deserialization matter in backend development.
