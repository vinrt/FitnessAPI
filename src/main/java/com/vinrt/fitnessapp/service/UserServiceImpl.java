package com.vinrt.fitnessapp.service;

import com.mongodb.client.MongoCollection;
import com.vinrt.fitnessapp.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserServiceInt {

    private final DbService dbService;

    public UserServiceImpl(DbService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void addUser(User customer) {
        String collectionName = "profileCollection";
        dbService.createCollectionIfNotExists(collectionName);
        try {
            MongoCollection<User> collection = dbService.getDatabase().getCollection(collectionName, User.class);
            collection.insertOne(customer);

        } catch (Exception e) {
            System.out.println("Something wrong while writing to the collection");
            throw new RuntimeException(e);
        }

    }
}
