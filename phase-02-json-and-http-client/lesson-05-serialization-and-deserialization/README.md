
# Lesson 5: JSON Serialization and Deserialization

## Overview

This lesson covers how Java applications convert Java objects into JSON and JSON data back into Java objects.

These processes are essential in backend development because REST APIs frequently exchange information using JSON.

## Learning Objectives

By the end of this lesson, I can:

- [x] Understand serialization.
- [x] Understand deserialization.
- [x] Explain the difference between serialization and deserialization.
- [x] Understand how Java objects are converted into JSON.
- [x] Understand how JSON is converted into Java objects.
- [x] Understand the role of Jackson.
- [x] Understand the Jackson ObjectMapper class.
- [x] Identify important Jackson methods.

## 1. What Is Serialization?

Serialization is the process of converting a Java object into a format that can be stored or transmitted, such as JSON.

Example Java object:

```java
Product product = new Product(
    1,
    "iPhone 15",
    650000
);
```

Serialized JSON:

```json
{
  "id": 1,
  "name": "iPhone 15",
  "price": 650000
}
```

Direction:

Java Object → JSON

### Why Serialization Is Important

- Sending data from a Java backend to a frontend.
- Returning JSON responses from REST APIs.
- Storing structured data.
- Exchanging information between applications.

## 2. What Is Deserialization?

Deserialization is the reverse process.

It converts JSON data into a Java object.

Example JSON:

```json
{
  "id": 10,
  "name": "Samsung S24",
  "price": 800000
}
```

The JSON can be converted into a Java Product object.

Direction:

JSON → Java Object

### Why Deserialization Is Important

- Receiving data from frontend applications.
- Processing external API responses.
- Converting incoming JSON into Java objects.
- Working with structured application data.

## 3. Serialization vs Deserialization

| Feature | Serialization | Deserialization |
|---|---|---|
| Direction | Java → JSON | JSON → Java |
| Purpose | Send or store data | Read and process data |
| Example | Sending product data | Receiving product data |
| Common use | API responses | API requests |

## 4. Understanding a Java Object

Example Product class:

```java
public class Product {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```

Creating an object:

```java
Product product = new Product(
    1,
    "iPhone 15",
    650000
);
```

A Java object is not automatically JSON. A JSON processing library is needed to convert it.

## 5. Jackson

Jackson is a popular Java library used for processing JSON.

It supports:

- Serialization.
- Deserialization.
- Reading JSON.
- Writing JSON.
- Mapping JSON properties to Java object fields.

We will use Jackson for practical JSON processing in Lesson 6.

## 6. ObjectMapper

`ObjectMapper` is a Jackson class responsible for JSON processing.

Example:

```java
ObjectMapper mapper = new ObjectMapper();
```

It provides methods for converting Java objects and JSON.

### Serialization with writeValueAsString()

```java
String json = mapper.writeValueAsString(product);
```

This converts a Java object into a JSON string.

Possible output:

```json
{
  "id": 1,
  "name": "iPhone 15",
  "price": 650000.0
}
```

Important:

- `writeValueAsString()` performs serialization.
- The returned value has the Java data type `String`.

### Deserialization with readValue()

```java
Product product = mapper.readValue(json, Product.class);
```

This converts JSON into a Java Product object.

Important:

- `readValue()` performs deserialization.
- `Product.class` tells Jackson the Java type to create.
- Jackson needs an appropriate way to construct the object, such as a no-argument constructor and setters or a configured creator.

## 7. Serialization and Deserialization in Backend Development

Consider an online shopping application.

### Step 1: Frontend Sends JSON

```json
{
  "name": "MacBook Pro",
  "price": 2500000
}
```

### Step 2: Backend Receives JSON

The Java backend deserializes the JSON into a Java object.

### Step 3: Backend Processes the Object

The application validates the product and saves it to the database.

### Step 4: Backend Returns JSON

The backend serializes a Java object into JSON.

```json
{
  "id": 101,
  "name": "MacBook Pro",
  "price": 2500000,
  "message": "Product created successfully"
}
```

This is a fundamental process in REST API development.

## Important Concepts

| Term | Meaning |
|---|---|
| Java Object | An instance of a Java class |
| JSON String | JSON data represented as a Java String |
| Serialization | Java object to JSON |
| Deserialization | JSON to Java object |
| Jackson | Java library for JSON processing |
| ObjectMapper | Jackson class used to process JSON |
| writeValueAsString() | Serializes a Java object |
| readValue() | Deserializes JSON |
| Product.class | Specifies the Java target type |

## Practical Exercise Results

Score: **8/10**

Correctly demonstrated understanding of:

- Serialization and deserialization.
- Jackson.
- ObjectMapper.
- JSON conversion methods.

Areas to improve:

- Distinguishing a Java object's data type from a JSON string's data type.
- Understanding how `.class` specifies the target Java type during deserialization.

## Knowledge Check Results

Score: **5/5**

All five quiz questions answered correctly.

## Lesson Status

- [x] Lesson completed.
- [x] Practical exercise completed.
- [x] Knowledge check completed.
- [x] README documentation completed.

## Next Lesson

**Lesson 6: JSON Processing in Java with Jackson**

Topics:

- Adding Jackson to a Maven project.
- Understanding ObjectMapper in practice.
- Serializing Java objects into JSON.
- Deserializing JSON into Java objects.
- Working with nested JSON.
- Handling JSON processing exceptions.
- Building a practical Java JSON application.
