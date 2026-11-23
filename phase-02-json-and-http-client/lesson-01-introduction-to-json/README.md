
# Lesson 1: Introduction to JSON

## Overview

This lesson introduces JSON (JavaScript Object Notation), a lightweight data-interchange format used to exchange information between applications.

JSON is widely used in REST APIs, web applications, mobile applications, and backend systems.

## Learning Objectives

By the end of this lesson, I should be able to:

- Explain what JSON means.
- Understand why JSON is used in application development.
- Identify JSON objects and key-value pairs.
- Understand the basic structure of JSON.
- Distinguish between JSON data and Java objects.
- Explain serialization and deserialization.
- Understand how different programming languages process JSON.

## Topics Covered

- Introduction to JSON
- Meaning of JavaScript Object Notation
- JSON syntax and structure
- JSON objects
- Keys and values
- JSON vs Java objects
- Serialization
- Deserialization
- Common uses of JSON

## Example: JSON Object

```json
{
  "id": 1,
  "name": "MacBook Pro",
  "price": 2500000,
  "inStock": true,
  "quantity": 5
}
```

### Understanding the Example

| Element | Meaning |
|---|---|
| `{ }` | Defines a JSON object |
| `id` | Key |
| `1` | Value |
| `name` | Key |
| `MacBook Pro` | Value |
| `price` | Key |
| `2500000` | Numeric value |
| `inStock` | Key |
| `true` | Boolean value |

## Important Concepts

### 1. JSON

JSON stands for JavaScript Object Notation. It is a lightweight format for storing and exchanging data.

### 2. Serialization

Converting a Java object into JSON.

**Java Object → JSON**

### 3. Deserialization

Converting JSON data into a Java object.

**JSON → Java Object**

### 4. JSON and Java

JSON is not exclusive to JavaScript. Java applications can also process JSON using libraries such as Jackson.

## Knowledge Check

- [x] Quiz completed
- [x] Score: 5/5 (100%)
- [x] Lesson 1 completed

## Practical Exercise

Given the JSON object below:

```json
{
  "product": "MacBook Pro",
  "price": 2500000,
  "inStock": true,
  "quantity": 5
}
```

Tasks:

1. Identify the JSON keys.
2. Identify the value of `product`.
3. Identify the value of `price`.
4. Identify the data type of `inStock`.
5. Count the number of key-value pairs.

## Lesson Status

**Completed**

## Next Lesson

Lesson 2: JSON Data Types
