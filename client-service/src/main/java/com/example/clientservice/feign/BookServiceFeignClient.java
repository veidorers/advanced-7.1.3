package com.example.clientservice.feign;

import com.example.clientservice.model.Book;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service")
@CircuitBreaker(name = "book-service", fallbackMethod = "fallback")
public interface BookServiceFeignClient {
    @GetMapping("/api/books")
    List<Book> getBooks();

    default List<Book> fallback(Throwable ex) {
        final Logger logger = LogManager.getLogger(BookServiceFeignClient.class);
        logger.warn("CUSTOM LOG - " + ex.getMessage());
        return List.of(Book.builder()
                        .id("fallback-book-id")
                        .title("fallback-book-title")
                        .description("fallback-book-description")
                        .imageLink("fallback-book-image-link")
                .build());

    }
}
