package com.example.transapp_back2.dao;

import com.example.transapp_back2.Logic.DbSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class SearchDAO {
    private final String dbCollection;
    private DbSettings dbSettings;

    public SearchDAO(){
        dbCollection = "trains";
    }

    public List<Document> getTrainsOfSearch(){
        MongoCollection<Document> collection = getMongoCollection();
        FindIterable<Document> findIterable = findTrainsIterable(collection);
        List<Document> trainList = createTrainList(findIterable);
        dbSettings.closeDb();
        return trainList;
    }

    private MongoCollection<Document> getMongoCollection(){
        dbSettings = new DbSettings();
        return dbSettings.setupDb(dbCollection);
    }

    private FindIterable<Document> findTrainsIterable (MongoCollection<Document> collection){
        return collection.find(Filters.eq("id", "1000"));
    }

    private List<Document> createTrainList(FindIterable<Document> findTrainsIterable){
        List<Document> trainList = new ArrayList<>();
        for (Document doc : findTrainsIterable) {
            trainList.add(doc);
        }
        return trainList;
    }










}
