package com.example.clientservice.controller;

import com.example.clientservice.feign.BookServiceFeignClient;
import com.example.clientservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final BookServiceFeignClient bookServiceFeignClient;

    @Autowired
    public ClientController(@Qualifier("com.example.clientservice.feign.BookServiceFeignClient") BookServiceFeignClient bookServiceFeignClient) {
        this.bookServiceFeignClient = bookServiceFeignClient;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookServiceFeignClient.getBooks();
    }
}
