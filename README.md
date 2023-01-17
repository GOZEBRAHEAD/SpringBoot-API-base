
# Base for a Spring Boot API

The main idea behind this is to have a _ready-to-go_ class as a base to use it as an API.
In this case, I decided to just create one class (Product), so it can be something simple but easy to modify, giving us a good starting point for our project.
## [API documentation]

#### Get all products

```java
  GET /products/get/all
```

| Description                                   |
| :-------------------------------------------- |
| *Returns all the products from the database.* |

##

#### Get a specific product

```java
  GET /products/get/{id}
```

| Description                                   |
| :-------------------------------------------- |
| *{id} represents the product ID to get*      |

##

#### Create a new product

```java
  POST /products/new
```

| Description                                                                       |
| :---------------------------------------------------------------------------------|
| *It uses a RequestBody, so you have to pass a product when calling the function.* |

##

#### Edit a product

```java
  PUT /products/edit/{id}
```

| Description                                   |
| :-------------------------------------------- |
| *{id} represents the product ID to edit*     |
| *It uses a RequestBody, so you have to pass a product when calling the function.* |

##

#### Delete a product

```java
  DELETE /products/delete/{id}
```

| Description                                   |
| :-------------------------------------------- |
| *{id} represents the product ID to delete*   |
