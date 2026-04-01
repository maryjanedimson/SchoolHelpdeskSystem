package com.company.schoolhelpdesksystem;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Database connection class for MongoDB
 */
public class DatabaseConnection {

    // Update this with your MongoDB connection string
    // For local MongoDB: "mongodb://localhost:27017"
    // For MongoDB Atlas: "mongodb+srv://username:password@cluster.mongodb.net/?retryWrites=true&w=majority"
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    private static final String DATABASE_NAME = "schoolhelpdesk";

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
        }
    }
}