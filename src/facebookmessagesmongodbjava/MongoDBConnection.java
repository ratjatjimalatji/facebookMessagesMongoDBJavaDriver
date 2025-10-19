
package facebookmessagesmongodbjava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoClient client;
    private static MongoDatabase database;

    public static MongoDatabase getConnection() {
        if (database == null) {
            client = MongoClients.create("mongodb://localhost:27017"); 
            database = client.getDatabase("facebook"); 
        }
        return database;
    }
}