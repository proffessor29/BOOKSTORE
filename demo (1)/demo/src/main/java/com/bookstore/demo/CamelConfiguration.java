package com.bookstore.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {

    @Bean
    public RouteBuilder route() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                rest("/books")
                    .get()
                        .route()
                        .bean(BookService.class, "getAllBooks")
                        .endRest()
                    .get("/{id}")
                        .route()
                        .bean(BookService.class, "getBook(${header.id})")
                        .endRest()
                    .post()
                        .type(Book.class)
                        .route()
                        .bean(BookService.class, "addBook")
                        .endRest()
                    .put("/{id}")
                        .type(Book.class)
                        .route()
                        .bean(BookService.class, "updateBook(${header.id})")
                        .endRest()
                    .delete("/{id}")
                        .route()
                        .bean(BookService.class, "deleteBook(${header.id})")
                        .endRest();
            }
        };
    }
}
