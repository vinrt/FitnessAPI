package com.vinrt.fitnessapp.dbconfig;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MongoDbClient {

    @Bean
    public MongoCollection createClient() {
        final String databaseName = "test-poc";
        String connectionString = "mongodb://127.0.0.1:27017";

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection("test-poc-collection");

        Document doc = new Document("name", "Vinay").append("phoneNo", "0762325521");
        collection.insertOne(doc);

        System.out.println("Inserted doc to collection : " + collection);
        return collection;
    }
}


