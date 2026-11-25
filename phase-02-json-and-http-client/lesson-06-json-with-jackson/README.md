# Lesson 6: JSON Processing in Java with Jackson

## Overview

This lesson covers how to process JSON data in Java using the Jackson library.

Jackson allows Java applications to serialize Java objects into JSON and deserialize JSON into Java objects.

**Technology:** Java 25, Maven, Jackson Databind 2.20.1

**Package:** `com.codewithkanye`

## Learning Objectives

By the end of this lesson, I learned how to:

- Understand the Jackson library.
- Configure Jackson dependencies using Maven.
- Create and use the `ObjectMapper` class.
- Serialize Java objects into JSON.
- Deserialize JSON into Java objects.
- Process nested JSON objects.
- Handle JSON processing exceptions.

## 1. Introduction to Jackson

Jackson is a Java library used to process JSON data.

The main class used in this lesson is:

```java
ObjectMapper mapper = new ObjectMapper();
```

`ObjectMapper` provides methods for converting between Java objects and JSON.

## 2. Maven Dependencies

The following dependencies were added to `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.20.1</version>
    </dependency>

    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-core</artifactId>
        <version>2.20.1</version>
    </dependency>

    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-annotations</artifactId>
        <version>2.20</version>
    </dependency>
</dependencies>
```

### Dependency responsibilities

- `jackson-databind`: Converts Java objects to and from JSON.
- `jackson-core`: Handles JSON parsing and generation.
- `jackson-annotations`: Provides annotations for customizing JSON processing.

## 3. Serialization

Serialization converts a Java object into a JSON String.

Example:

```java
Product product = new Product(
    1,
    "iPhone 15",
    650000
);

ObjectMapper mapper = new ObjectMapper();

String json = mapper.writeValueAsString(product);

System.out.println(json);
```

Expected output:

```json
{"id":1,"name":"iPhone 15","price":650000.0}
```

The important method is:

```java
mapper.writeValueAsString(product);
```

## 4. Pretty Printing

Jackson can format JSON to make it easier to read.

```java
String json = mapper
    .writerWithDefaultPrettyPrinter()
    .writeValueAsString(product);
```

## 5. Deserialization

Deserialization converts a JSON String into a Java object.

Example:

```java
String json = """
    {
        "id": 2,
        "name": "Samsung S24",
        "price": 800000
    }
    """;

Product product = mapper.readValue(json, Product.class);

System.out.println(product.getName());
```

Expected output:

```text
Samsung S24
```

### Important methods

| Method | Purpose |
|---|---|
| `writeValueAsString()` | Java object to JSON |
| `readValue()` | JSON to Java object |
| `writerWithDefaultPrettyPrinter()` | Formats JSON for readability |

`Product.class` tells Jackson which Java class to use when creating the object from JSON.

## 6. Nested JSON with Jackson

Nested JSON contains objects inside other objects.

Example:

```json
{
    "id": 1,
    "name": "Albert",
    "address": {
        "city": "Lagos",
        "country": "Nigeria"
    }
}
```

Java representation:

```java
public class User {
    private int id;
    private String name;
    private Address address;

    public User() {}

    // Getters and setters
}
```

The `Address` class:

```java
public class Address {
    private String city;
    private String country;

    public Address() {}

    // Getters and setters
}
```

Jackson can automatically map the nested JSON address into an `Address` Java object.

Accessing the nested values:

```java
user.getAddress().getCity();
user.getAddress().getCountry();
```

This is an example of **object composition**: one Java object contains another Java object.

## 7. Exception Handling

JSON processing can fail when the JSON is malformed or does not match the expected Java type.

Example:

```java
try {
    User user = mapper.readValue(json, User.class);

    System.out.println(user.getName());

} catch (Exception e) {
    System.out.println(
        "Error processing JSON: " + e.getMessage()
    );
}
```

Important concepts:

- `try`: Contains code that might fail.
- `catch`: Handles an exception.
- `e.getMessage()`: Returns a description of the exception.

In production applications, specific exceptions should be handled where appropriate.

## 8. Important Concepts Learned

| Concept | Meaning |
|---|---|
| Jackson | Java library for JSON processing |
| ObjectMapper | Main Jackson class for JSON conversion |
| Serialization | Java object to JSON |
| Deserialization | JSON to Java object |
| Object composition | One Java object contains another |
| No-argument constructor | Allows Jackson to instantiate a Java object in common POJO-based mappings |
| Exception handling | Handles errors without unexpected application termination |

## 9. Practical Work Completed

- [x] Added Jackson dependencies to Maven.
- [x] Configured `ObjectMapper`.
- [x] Implemented Java object serialization.
- [x] Implemented JSON deserialization.
- [x] Worked with nested JSON objects.
- [x] Practised exception handling.
- [x] Successfully compiled the Maven project.
- [x] Successfully executed the Jackson application.

## 10. Assessment Results

| Assessment | Score |
|---|---:|
| Exercise A: Concepts | 9/10 |
| Exercise B: Code Understanding | 4/5 |
| Exercise C: Multiple Choice | 5/5 |
| **Total** | **18/20 (90%)** |

**Status: PASSED**

## 11. Key Takeaways

1. Jackson makes JSON processing easier in Java.
2. `ObjectMapper` is the main class used for JSON conversion.
3. Serialization converts Java objects into JSON.
4. Deserialization converts JSON into Java objects.
5. Nested JSON can be represented using Java object composition.
6. Exception handling helps applications deal with invalid JSON and mapping errors.

## Lesson Status

- [x] Lesson 6: JSON Processing in Java with Jackson

**Phase 2: JSON and Java HttpClient**

**Next Lesson:** Lesson 7 — Introduction to Java HttpClient.