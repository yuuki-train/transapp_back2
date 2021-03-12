package com.example.transapp_back2.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SearchDAO {

    public long checkRecords() {


        ConnectionString connection = new ConnectionString(
                "mongodb+srv://yuuki:yuukidb@cluster0.wdfqa.mongodb.net/transapp?retryWrites=true&w=majority"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connection)
                .retryWrites(true)
                .build();

        MongoClient client = MongoClients.create(settings);
        MongoDatabase database = client.getDatabase("transapp");
        MongoCollection<Document> saveData = database.getCollection("savedata");
        long records = saveData.countDocuments();
        client.close();
        return records;
    }

}
