# Lesson 9 — DNS, Ports, TCP and TLS

## 1. DNS (Domain Name System)

DNS translates human-readable domain names into IP addresses.

Example:

```text
example.com → IP address
```

DNS helps computers discover the network address associated with a domain name.

## 2. IP Addresses

An IP address identifies a device or network interface on a network.

Two main versions:

- IPv4: `192.168.1.10`
- IPv6: `2001:db8:85a3::8a2e:370:7334`

A domain name is human-readable, while an IP address is used for network communication.

## 3. Ports

A port identifies a particular service or application endpoint on a machine.

Common ports:

| Port | Service |
|---|---|
| 22 | SSH |
| 25 | SMTP |
| 80 | HTTP |
| 443 | HTTPS |
| 3306 | MySQL |
| 5432 | PostgreSQL |
| 8080 | Common development server port |

Example:

```text
http://localhost:8080/api/products
```

- `http` — Protocol
- `localhost` — Host
- `8080` — Port
- `/api/products` — Path

## 4. TCP (Transmission Control Protocol)

TCP provides reliable, ordered delivery of data between applications.

### TCP three-way handshake

1. SYN — Client requests a connection.
2. SYN-ACK — Server acknowledges and responds.
3. ACK — Client acknowledges the server.

TCP provides:
- Reliable data delivery.
- Ordered transmission.
- Error detection and retransmission.
- Flow and congestion control.

## 5. TLS (Transport Layer Security)

TLS secures communication between a client and server.

It provides:
- Confidentiality.
- Integrity.
- Authentication.

HTTPS uses TLS to protect HTTP communication.

## 6. How DNS, TCP, TLS and HTTP work together

When visiting:

```text
https://example.com/api/products
```

The simplified process is:

1. DNS resolves the domain name to an IP address.
2. TCP establishes a connection.
3. TLS establishes secure communication.
4. HTTP sends a request.
5. The server returns an HTTP response.

Note: HTTP/3 uses QUIC rather than TCP.

## 7. Java Backend Engineering Relevance

A Java backend application may listen on:

```text
http://localhost:8080
```

When deployed, backend engineers must understand:

- DNS configuration.
- Server IP addresses.
- Application ports.
- TCP connections.
- TLS certificates.
- HTTPS configuration.

These concepts are important when deploying Spring Boot applications to cloud infrastructure.

## Key Takeaways

- DNS translates domain names into IP addresses.
- IP addresses identify network destinations.
- Ports identify application endpoints.
- TCP provides reliable, ordered communication.
- TLS secures communication.
- HTTP defines how requests and responses are exchanged.

**Lesson Status: Completed**