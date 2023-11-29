# Coffee Ordering Application

This Java application is a simple coffee ordering system with Spring Boot and JPA (Java Persistence API). It manages entities such as users, orders, products, and categories, providing a foundation for building a coffee ordering platform.

## Domain Classes

### Category
Represents a coffee category with an ID, name, and ingredients.

### Order
Represents a user's order with an ID, associated user, and product.

### Product
Represents a coffee product with an ID, name, price, and an associated category.

### User
Represents a user with an ID, role (e.g., USER or ADMIN), username, password, and a list of associated orders.

## Controllers and Endpoints

### CategoryController

#### Get All Categories

## Configuration

### WebSecurityConfiguration

Configures Spring Security for the application, providing authentication and authorization settings. It includes configurations for HTTP security, authentication manager, password encoder, and security filter chain.

## Usage Guidelines

### Running the Application:

1. Clone the repository.
2. Open the project in IntelliJ IDEA or your preferred IDE.
3. Run the `Application` class to start the Spring Boot application.

### Database Configuration:

- The application uses an embedded H2 database by default.
- Check the `application.properties` file for database configuration.

# API Endpoints:

## CategoryController

### Get All Categories
- **Method:** GET
- **Endpoint:** /categories
- **Description:** Retrieve a list of all coffee categories.

### Get Category by ID
- **Method:** GET
- **Endpoint:** /categories/{category_id}
- **Description:** Retrieve a specific coffee category by its ID.

## OrderController

### Get Order by ID
- **Method:** GET
- **Endpoint:** /orders/{order_id}
- **Description:** Retrieve a specific order by its ID.

### Create Order
- **Method:** POST
- **Endpoint:** /orders
- **Description:** Create a new order.

## ProductController

### Get Products
- **Method:** GET
- **Endpoint:** /products?limit={limit}&sort={sort}
- **Description:** Retrieve a list of products with optional limit and sorting parameters.

### Get Product by ID
- **Method:** GET
- **Endpoint:** /products/{id}
- **Description:** Retrieve a specific product by its ID.

### Create Product
- **Method:** POST
- **Endpoint:** /products
- **Description:** Create a new product.

### Delete Product
- **Method:** DELETE
- **Endpoint:** /products/{id}
- **Description:** Delete a product by its ID.

## UserController

### Get All Users
- **Method:** GET
- **Endpoint:** /users
- **Description:** Retrieve a list of all users.

### Get Orders from User
- **Method:** GET
- **Endpoint:** /users/{user_id}/orders
- **Description:** Retrieve a list of orders associated with a specific user.


### Security Configuration:

- The `WebSecurityConfiguration` class configures security settings.
- Admin users have access to specific endpoints (e.g., product deletion), while regular users have access to order and product creation.

### Authentication:

- Use HTTP Basic Authentication for accessing secured endpoints.
- Default admin credentials: Username - username1, Password - admin.
- Default user credentials: Username - username2, Password - user.

### H2 Console:

- Access H2 console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console).
- JDBC URL: `jdbc:h2:mem:testdb`
- Default username: sa
- Default password: (empty)
