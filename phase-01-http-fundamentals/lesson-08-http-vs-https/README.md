# Lesson 8 — HTTP vs HTTPS

## Learning Objectives

By the end of this lesson, I understand:
- The difference between HTTP and HTTPS.
- What TLS is and why it matters.
- The default ports used by HTTP and HTTPS.
- How TLS protects communication.
- The purpose of digital certificates and Certificate Authorities.
- How Java handles TLS certificate verification.

## 1. What is HTTP?

HTTP stands for **Hypertext Transfer Protocol**.

It is the communication protocol used by clients and servers to exchange information.

HTTP does not encrypt communication by itself. This means that information travelling over an ordinary HTTP connection may be intercepted or modified.

## 2. What is HTTPS?

HTTPS stands for **Hypertext Transfer Protocol Secure**.

HTTPS is HTTP protected by TLS (Transport Layer Security).

TLS helps protect communication between a client and a server.

| Protocol | Default Port | Encryption |
|---|---:|---|
| HTTP | 80 | No encryption by default |
| HTTPS | 443 | Protected by TLS |

## 3. What is TLS?

TLS means **Transport Layer Security**.

It is a security protocol that protects data travelling between a client and a server.

TLS provides three important security properties:

### Confidentiality
Prevents unauthorized people from reading transmitted information.

### Integrity
Helps ensure that transmitted information has not been modified without detection.

### Authentication
Helps verify the identity of the server through its digital certificate.

## 4. How the TLS Handshake Works

Before encrypted communication begins, the client and server perform a process called the TLS handshake.

Simplified steps:

1. The client sends a ClientHello message.
2. The server responds with its selected TLS settings and digital certificate.
3. The client verifies the server's certificate.
4. The client and server establish shared session keys.
5. Encrypted HTTP communication begins.

The actual handshake involves additional details depending on the TLS version.

## 5. Digital Certificates

A digital certificate helps prove the identity of a website or server.

A browser or client checks details such as:

- Whether the certificate is issued by a trusted Certificate Authority.
- Whether the certificate matches the requested domain.
- Whether the certificate is within its validity period.
- Whether there are certificate revocation problems.

### Certificate Authority (CA)

A Certificate Authority is an organization trusted to issue digital certificates and help verify identities.

Examples:
- Let's Encrypt
- DigiCert

**Important:** A valid HTTPS certificate does not guarantee that a website is honest, safe, or legitimate.

## 6. Why HTTPS Matters

HTTPS protects sensitive information travelling between clients and servers, including:

- Login credentials.
- Authentication tokens.
- Personal information.
- Payment information.
- Business data.

HTTPS protects communication in transit. It does not replace secure password storage, authentication, authorization, or input validation.

## 7. HTTP and HTTPS in Java

Java provides an HTTP client through `java.net.http.HttpClient`.

Example:

```java
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("HTTP client created!");
    }
}
```

Java's HTTP client verifies TLS certificates by default when making HTTPS connections.

**Security rule:** Never disable certificate verification in production just to make a connection work.

If a certificate is expired or invalid, investigate and resolve the certificate problem rather than automatically trusting it.

## 8. Key Takeaways

- HTTP is not encrypted by default.
- HTTPS is HTTP protected by TLS.
- HTTP uses default port 80.
- HTTPS uses default port 443.
- TLS provides confidentiality, integrity, and authentication.
- Digital certificates help verify server identity.
- Certificate Authorities issue trusted digital certificates.
- HTTPS does not guarantee that a website itself is trustworthy.
- Java validates TLS certificates by default.

## Lesson Completion

- [x] Understand HTTP and HTTPS.
- [x] Understand TLS.
- [x] Identify default HTTP and HTTPS ports.
- [x] Understand confidentiality, integrity, and authentication.
- [x] Understand digital certificates and Certificate Authorities.
- [x] Understand Java TLS certificate verification.
- [x] Complete practical exercises.
- [x] Pass the final knowledge check.

**Status: Completed**