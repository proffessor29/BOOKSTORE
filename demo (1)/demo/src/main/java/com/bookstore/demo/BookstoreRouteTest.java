package com.bookstore.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookstoreRouteTest extends CamelTestSupport {

    @Autowired
    private CamelContext camelContext;

    @Before
    public void setup() throws Exception {

    // Load the Camel route and configure it for testing
        context.getRouteDefinition("bookstoreRoute")
            .adviceWith(context, new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    // Replace the "to" endpoint with a mock endpoint for testing
                    interceptSendToEndpoint("direct:start")
                        .skipSendToOriginalEndpoint()
                        .to("mock:direct:start");
                }
        });

    // Start the Camel context
        context.start();
    }


    @Test
    public void testGetBooks() throws Exception {

        // Set up mock endpoint behavior
        getMockEndpoint("mock:direct:start").expectedMessageCount(1); // Expect one message to be received

        // Send a test message to the route
        template.sendBody("direct:start", "");

        // Assert that the mock endpoint received the expected message count
        assertMockEndpointsSatisfied();
    }

    @Test
    public void testGetBook() throws Exception {
        // Define your test logic for the GET /books/{id} route here

        // Set up mock endpoint behavior
        getMockEndpoint("mock:direct:start").expectedMessageCount(1); // Expect one message to be received
        getMockEndpoint("mock:direct:start").expectedHeader("id", "123"); // Expect the "id" header to be set to "123"

        // Send a test message to the route with the "id" header
        template.sendBodyAndHeader("direct:start", "", "id", "123");

        // Assert that the mock endpoint received the expected message count and header value
        assertMockEndpointsSatisfied();
    }

    @Test
    public void testAddBook() throws Exception {
        // Define your test logic for the POST /books route here

        // Set up mock endpoint behavior
        getMockEndpoint("mock:direct:start").expectedMessageCount(1); // Expect one message to be received

        // Prepare a test message representing a new book (adjust the message content as needed)
        String newBookJson = "{\"id\":\"123\",\"title\":\"Sample Book\",\"author\":\"John Doe\",\"publicationYear\":2023}";

        // Send the test message to the route
        template.sendBody("direct:start", newBookJson);

        // Assert that the mock endpoint received the expected message count
        assertMockEndpointsSatisfied();

        // Optionally, you can check the response from the route to verify the book was added.
    }

    @Test
    public void testUpdateBook() throws Exception {
        // Define your test logic for the PUT /books/{id} route here

        // Set up mock endpoint behavior
        getMockEndpoint("mock:direct:start").expectedMessageCount(1); // Expect one message to be received
        getMockEndpoint("mock:direct:start").expectedHeader("id", "123"); // Expect the "id" header to be set to "123"

        // Prepare a test message representing an updated book (adjust the message content as needed)
        String updatedBookJson = "{\"id\":\"123\",\"title\":\"Updated Book\",\"author\":\"Jane Smith\",\"publicationYear\":2024}";

        // Send the test message to the route with the "id" header
        template.sendBodyAndHeader("direct:start", updatedBookJson, "id", "123");

        // Assert that the mock endpoint received the expected message count and header value
        assertMockEndpointsSatisfied();

        // Optionally, you can check the response from the route to verify the book was updated.
    }

    @Test
    public void testDeleteBook() throws Exception {
        // Define your test logic for the DELETE /books/{id} route here

        // Set up mock endpoint behavior
        getMockEndpoint("mock:direct:start").expectedMessageCount(1); // Expect one message to be received
        getMockEndpoint("mock:direct:start").expectedHeader("id", "123"); // Expect the "id" header to be set to "123"

        // Send a test message to the route with the "id" header
        template.sendBodyAndHeader("direct:start", "", "id", "123");

        // Assert that the mock endpoint received the expected message count and header value
        assertMockEndpointsSatisfied();

        // Optionally, you can check the response from the route to verify the book was deleted.
    }
}