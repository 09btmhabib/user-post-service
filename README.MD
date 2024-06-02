# Spring Project: user-post-service

This README provides an overview of the Spring project user-post-service, including setup instructions, API endpoints, and security considerations.

## Project Setup

**Prerequisites:**

- Java Development Kit (JDK) 21 or higher
- Gradle 8.7

**Clone the Repository**

```bash
git clone https://github.com/09btmhabib/user-post-service.git
cd user-post-service
```

## API Endpoints

### Authentication

- *Endpoint:* `/api/auth/login`

#### Request Body (JSON)

```json
{
  "username": "test",
  "password": "test"
}
```

### Users (Requires authentication)

- **GET /users**
  - Retrieves a list of all users in the system.
  - Response: JSON array containing UserDto objects.
- **GET /users/{id}/posts**
  - Retrieves a list of posts authored by the specified user (identified by their ID).
  - Path Variable: id (Long) - Unique identifier of the user.
  - Response: JSON array containing PostDto objects.

### Posts (Requires authentication)

- **GET /posts**
  - Retrieves a list of all posts in the system.
  - Response: JSON array containing PostDto objects.
- **GET /posts/{id}/comments**
  - Retrieves a list of comments associated with the specified post (identified by its ID).
  - Path Variable: id (Long) - Unique identifier of the post.
  - Response: JSON array containing CommentDto objects.

### Comments (Requires authentication)

- **GET /comments**
  - Retrieves a list of all comments in the system.
  - Response: JSON array containing CommentDto objects.

  **Disclaimer:**
- Test cases have been skipped in code.
- I used the InMemoryUserDetailsManager 

