package com.example.transapp_back2.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public interface MongoDbSettings {
    void getDataFromDb();
    MongoCollection<Document> setUpMongoDB();
    void closeMongoDb();
}
