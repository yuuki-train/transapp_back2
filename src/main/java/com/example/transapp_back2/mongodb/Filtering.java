package com.example.transapp_back2.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Filtering {
    public FindIterable<Document> filterTrainData(MongoCollection<Document> operableCollection){
        return operableCollection.find(Filters.eq("trainNumber", "MD901"));
    }
}
