package com.example.bookservice.configuration;

import com.example.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public DataLoader(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = Arrays.asList(
                Book.builder().title("Book 1").description("Description 1").imageLink("Link 1").build(),
                Book.builder().title("Book 2").description("Description 2").imageLink("Link 2").build(),
                Book.builder().title("Book 3").description("Description 3").imageLink("Link 3").build()
        );
        mongoTemplate.insertAll(books);
    }
}
