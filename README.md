# Price Microservice

This is a Java 17 and Spring Boot microservice that provides a REST API for querying product prices in a database.

## Requirements

- Java 17
- Spring Boot 3.1.3
- H2 Database

## Configuration


### H2 Database

The microservice uses an in-memory H2 database to store price data. The database is automatically initialized with sample data when the application starts.

### Dependencies

The project uses the following core dependencies:

- Spring Boot Web: For creating a RESTful web application.
- Spring Data JPA: For interacting with the database.
- MapStruct: For mapping domain objects to DTOs.

## Endpoints

### GET /api/prices
Retrieve the most prioritized price based on application date, product identifier, and brand identifier.

#### Input Parameters

- `applicationDate`: Application date.
- `productId`: Product identifier.
- `brandId`: Brand identifier.

#### Example Request

- `curl --location 'http://localhost:8080/prices?applicationDate=2020-06-14T15%3A30%3A00&productId=35455&brandId=1'`

#### Example Response

```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 2,
  "startDate": "2023-09-05T00:00:00",
  "endDate": "2023-12-31T23:59:59",
  "finalPrice": 35.50
}
```

## Running

- Ensure you have Java 17 installed.
- Run the application using Maven
- The application will run at http://localhost:8080.

## Testing

- The project includes tests with a data set in H2.



Thank you for using the Price Microservice!

