User Service Endpoints

1. Register a New User
Endpoint: POST /users

{
    "username": "First Name",
    "password": "passwordfirst",
    "role": "USER"
}

2. Get All Users
Endpoint: GET /users

3. Get User by ID
Endpoint: GET /users/{id}

Example:
GET /users/1

4. Update User
Endpoint: PUT /users/{id}

Request Body:
{
    "username": "First Name",
    "password": "newpassword123",
    "role": "ADMIN"
}

Example:PUT /users/1

5. Delete User
Endpoint: DELETE /users/{id}

Example: DELETE /users/1

Journal End Points
1. Get All Journals
Endpoint: GET /journals


Docker
docker compose up --build