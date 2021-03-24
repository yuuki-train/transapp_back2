package com.example.transapp_back2.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

public class FindFromDb {

    private final MongoCollection<Document> operableCollection;

    public FindFromDb(MongoCollection<Document> operableCollection){
        this.operableCollection = operableCollection;
    }

    public FindIterable<Document> findDataFromDb(List<String> searchFilter){
        return operableCollection.find(Filters.eq("trainNumber", "MD901"));
    }


    public FindIterable<Document> filterTrainData(){
        return operableCollection.find(Filters.eq("trainNumber", "MD901"));
    }


    public FindIterable<Document> searchStationNameList(String station){
         return operableCollection.find(Filters.in("stationsOfLine", station));
    }

}