package com.vinrt.fitnessapp.service;


import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DbService {
    private final MongoDatabase mongoDatabase;

    public DbService(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public void createCollectionIfNotExists(String collectionName) {
        boolean exists = mongoDatabase.listCollectionNames()
                .into(new ArrayList<>())
                .contains(collectionName);

        if(!exists) {
            mongoDatabase.createCollection(collectionName);
            System.out.println("Collection created: " + collectionName);
        } else {
            System.out.println("Collection already exists: " + collectionName);
        }
    }

    public MongoDatabase getDatabase() {
        return this.mongoDatabase;
    }
}
