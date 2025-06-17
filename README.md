# Projeto Web Services com Spring Boot e JPA / Hibernate

## Objetivos Desse Projeto

- Criar Projeto Spring Boot Java
- Implementar Modelo de Momínio
- Estruturar Camadas Lógicas: Resource, Service, Repository
- Configurar Banco de Dados de Teste (H2)
- CRUD - Create, Retrieve, Update, Delete
- Realizar Tratamento de Exceções

## Diagrama de Classe

```mermaid
classDiagram
    class Product {
        <<pk>> Integer id
        String name
        String description
        Double price
        String imgUrl
    }

    class Category {
        <<pk>> Integer id
        String name
    }

    class Order {
        <<pk>> Integer id
        Date moment
        OrderStatus orderStatus
        + Double total()
    }

    class OrderItem {
        Integer quantity
        Double price
        + Double subTotal()
    }

    class Payment {
        <<pk>> Integer id
        Date moment
    }

    class User {
        <<pk>> Integer id
        String name
        String email
        String String
        String password
    }

    class OrderStatus {
        WAITING_PAYMENT
        PAID
        SHIPPED
        DELIVERED
        CANCELED
    }

    Product "1..*" -- "1" OrderItem : items
    Order "1" -- "1" OrderItem : order
    Product "1..*" -- "1" Category : products --> categories
    Order "*" -- "1" User : client
    Order "1" -- "0..1" Payment : payment
```

## Tecnologias

- Java
- Spring Boot
- Apache Tomcat
- Maven
- H2 Database
- PostgreSQL
- Heroku
- Postman
