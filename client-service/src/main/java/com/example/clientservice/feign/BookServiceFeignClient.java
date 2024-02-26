package com.example.clientservice.feign;

import com.example.clientservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "book-service", fallback = BookServiceFeignClient.Fallback.class)
public interface BookServiceFeignClient {
    @GetMapping("/api/books")
    List<Book> getBooks();

    @Component
    class Fallback implements BookServiceFeignClient {
        @Override
        public List<Book> getBooks() {
            return Collections.emptyList();
        }
    }
}
