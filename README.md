# # Bookstore API

The Bookstore API is a simple RESTful service built with Apache Camel and Spring Boot that allows you to manage a collection of books. This README provides instructions on how to build and run the application.

## Prerequisites

Before you can build and run the Bookstore API, make sure you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven (https://maven.apache.org/)
- Git (optional, but recommended for cloning the repository)

## Getting Started

Follow these steps to build and run the Bookstore API:

1. **Clone the Repository** (If you haven't already):


2. **Navigate to the Project Directory**:


3. **Build the Application**:

Use Maven to build the application. This command will download dependencies, compile the code, and package the application into a JAR file.


4. **Run the Application**:

After successfully building the application, you can run it with the following command:


The application will start, and you will see log output indicating that it's running.

5. **Access the API**:

Once the application is running, you can access the API using your web browser or a tool like [Postman](https://www.postman.com/) or [curl](https://curl.se/). The API is available at:


You can use various HTTP methods (GET, POST, PUT, DELETE) to interact with the API to manage the collection of books.

6. **Swagger Documentation**:

The API documentation can be accessed using Swagger UI. Open your web browser and navigate to:


Swagger provides a user-friendly interface for exploring and testing the API endpoints.

7. **Shut Down the Application**:

To stop the application, press `Ctrl + C` in the terminal where it's running.

## Configuration

The Bookstore API can be configured by modifying the `application.properties` or `application.yml` file in the `src/main/resources` directory.

## Testing

The project includes unit tests for the Camel routes. You can run the tests with the following command:


## Contributing

If you'd like to contribute to this project, please follow the [Contribution Guidelines](CONTRIBUTING.md).

