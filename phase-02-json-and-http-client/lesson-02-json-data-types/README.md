
# Lesson 2: JSON Data Types

## Overview

This lesson covers the six data types supported by JSON and how to identify them when working with JSON data in Java backend development.

JSON supports strings, numbers, booleans, null, objects, and arrays.

## Learning Objectives

By the end of this lesson, I should be able to:

- Identify the six JSON data types.
- Understand the difference between strings and numbers.
- Understand Boolean values.
- Explain the meaning of null.
- Identify JSON objects and arrays.
- Distinguish between objects and arrays.
- Understand how JSON data types relate to Java data types.

## Topics Covered

- JSON Strings
- JSON Numbers
- JSON Booleans
- JSON Null
- JSON Objects
- JSON Arrays
- JSON and Java data type mapping

## 1. JSON String

A string represents text and must be enclosed in double quotation marks.

Example:

```json
{
  "name": "Albert",
  "country": "Nigeria"
}
```

## 2. JSON Number

Numbers represent numeric values and do not require quotation marks.

Example:

```json
{
  "age": 24,
  "price": 650000,
  "rating": 4.8
}
```

## 3. JSON Boolean

A Boolean represents either true or false.

Example:

```json
{
  "isAvailable": true,
  "isDeleted": false
}
```

## 4. JSON Null

Null represents the absence of a value.

Example:

```json
{
  "middleName": null
}
```

## 5. JSON Object

An object stores data as key-value pairs using curly braces `{}`.

Example:

```json
{
  "id": 101,
  "name": "Albert"
}
```

## 6. JSON Array

An array stores multiple values using square brackets `[]`.

Example:

```json
{
  "skills": [
    "Java",
    "SQL",
    "Spring Boot"
  ]
}
```

## JSON Data Types Reference

| JSON Type | Example | Java Representation |
|---|---|---|
| String | `"Java"` | String |
| Number | `25` | int, long, double, BigDecimal |
| Boolean | `true` | boolean / Boolean |
| Null | `null` | null |
| Object | `{ "age": 24 }` | Java object |
| Array | `[1, 2, 3]` | Array / List |

## Practical Exercise

Given this JSON object:

```json
{
  "id": 101,
  "name": "Albert",
  "age": 24,
  "isDeveloper": true,
  "salary": 350000.50,
  "middleName": null,
  "skills": ["Java", "SQL", "Spring Boot"],
  "address": {
    "country": "Nigeria",
    "city": "Lagos"
  }
}
```

Tasks:

1. Identify the data type of name.
2. Identify the data type of age.
3. Identify the data type of isDeveloper.
4. Identify the data type of salary.
5. Explain what middleName: null means.
6. Identify the data type of skills.
7. Identify the data type of address.
8. Is "24" a number or a string?
9. Is false a valid JSON Boolean?
10. Which symbols define a JSON array?

## Knowledge Check Results

- [x] Quiz completed
- [x] Score: 5/5 (100%)
- [x] Lesson completed

## Important Concepts Learned

- JSON supports six data types.
- Strings require double quotation marks.
- Numbers do not require quotation marks.
- Boolean values are true or false.
- Null represents the absence of a value.
- Objects use curly braces `{}`.
- Arrays use square brackets `[]`.
- Java can represent JSON data using classes, arrays, Lists, and primitive or wrapper types.

## Lesson Status

**Completed**

## Next Lesson

Lesson 3: JSON Objects and Arrays
