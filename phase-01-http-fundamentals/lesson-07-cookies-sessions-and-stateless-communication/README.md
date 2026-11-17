# Lesson 7 — Cookies, Sessions and Stateless Communication

**Phase:** 1 — HTTP Fundamentals and Networking  
**Status:** Completed

## 1. What is Stateless Communication?

HTTP is stateless by default.

This means the server does not automatically remember previous requests from a client.

Each HTTP request is treated independently unless an additional mechanism is used to maintain state.

For example:
- A user logs in.
- The user requests their profile.
- The user requests their shopping cart.

The server needs a mechanism to recognize that these requests belong to the same authenticated user.

## 2. What are Cookies?

A cookie is a small piece of data that a website asks the browser to store.

The browser can send the cookie back to the server with subsequent requests.

Example:

```http
HTTP/1.1 200 OK
Set-Cookie: sessionId=abc123; HttpOnly; Secure; SameSite=Lax
```

Important parts:

- `Set-Cookie`: Instructs the browser to store a cookie.
- `sessionId`: Cookie name.
- `abc123`: Cookie value.
- `HttpOnly`: Prevents JavaScript from accessing the cookie.
- `Secure`: Restricts sending the cookie to HTTPS connections.
- `SameSite=Lax`: Helps restrict certain cross-site cookie requests.

When the browser makes another request:

```http
GET /api/profile HTTP/1.1
Cookie: sessionId=abc123
```

The browser sends the cookie to the server.

## 3. What are Sessions?

A session is a mechanism for maintaining information associated with a user across multiple requests.

In a common server-side session implementation:

1. User submits login credentials.
2. Server verifies the credentials.
3. Server creates a session.
4. Server generates a session ID.
5. Browser receives the session ID in a cookie.
6. Browser sends the cookie with subsequent requests.
7. Server uses the session ID to find the associated session.

A session may contain:
- User ID
- Authentication status
- Session creation time
- Session expiration time

The server can invalidate the session when the user logs out.

## 4. Cookies vs Sessions

| Cookies | Sessions |
|---|---|
| Usually stored in the browser | Session information commonly stored on the server |
| Sent with matching HTTP requests | Identified using a session ID |
| Can store small pieces of data | Can maintain information associated with a user |
| Can have an expiration date | Can expire or be invalidated |

Remember:

**Cookie = browser storage.**

**Session = server-maintained information.**

A cookie-based session commonly uses both together.

## 5. How Login Works

Example login request:

```http
POST /api/login HTTP/1.1
Content-Type: application/json

{
    "username": "admin",
    "password": "mypassword"
}
```

Successful response:

```http
HTTP/1.1 200 OK
Set-Cookie: sessionId=xyz789; HttpOnly; Secure; SameSite=Lax
Content-Type: application/json

{
    "message": "Login successful"
}
```

Subsequent request:

```http
GET /api/profile HTTP/1.1
Cookie: sessionId=xyz789
```

The server checks the session ID and determines whether the user has a valid session.

## 6. Important Cookie Security Attributes

| Attribute | Purpose |
|---|---|
| HttpOnly | Prevents JavaScript access to the cookie |
| Secure | Restricts cookie sending to HTTPS |
| SameSite | Helps control cross-site cookie sending |

Additional security practices:
- Never store plain-text passwords in cookies.
- Use HTTPS for authentication.
- Generate unpredictable session IDs.
- Expire and invalidate sessions appropriately.
- Protect against Cross-Site Request Forgery (CSRF).

## 7. Important HTTP Headers

**Set-Cookie:** Server instructs browser to store a cookie.

**Cookie:** Browser sends stored cookies to the server.

Example:

```http
Set-Cookie: sessionId=xyz789
```

```http
Cookie: sessionId=xyz789
```

## 8. Important Status Code

`401 Unauthorized` is used when a request lacks valid authentication credentials.

For example, an API can return 401 when a user has no valid session.

## 9. Knowledge Check Results

- First knowledge check: 6/6
- Practical exercise: 4/6 fully correct
- Final knowledge check: 5/6 fully correct

## Lesson Summary

I understand why HTTP is stateless, how cookies and sessions work together, how browsers send cookies to servers, and how cookie security attributes protect authentication-related information.

Next lesson: HTTP vs HTTPS.