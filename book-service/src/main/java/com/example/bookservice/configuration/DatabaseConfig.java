package com.example.bookservice.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class DatabaseConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "book_db";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27018");
    }
}
