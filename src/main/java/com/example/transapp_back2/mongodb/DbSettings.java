package com.example.transapp_back2.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public interface DbSettings {
    MongoCollection<Document> setUpDb(String dbCollection);
    void closeDb();
}
