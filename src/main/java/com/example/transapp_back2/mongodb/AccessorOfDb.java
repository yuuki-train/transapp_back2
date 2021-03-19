package com.example.transapp_back2.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class AccessorOfDb {
    private final String dbCollection;
    private final MongoCollection<Document> operableCollection;
    private Filtering filtering;
    private DbSettings dbSettings;
    private FindIterable<Document> dataIterable;
    private List<Document> listForReturn;

    public AccessorOfDb(String collectionName){
        dbCollection = collectionName;
        operableCollection = getMongoCollection();
    }

    private MongoCollection<Document> getMongoCollection(){
        dbSettings = new DbSettings();
        return dbSettings.setupDb(dbCollection);
    }

    public List<Document> getTrainDataForSearch(){
        getTrainDataList();
        return listForReturn;
    }

    public List<Document> getLinesAndStationsData(String station){
        getLinesAndStationsDataList(station);
        return listForReturn;
    }


    private void getTrainDataList (){
        filtering = new Filtering(operableCollection);
        dataIterable = filtering.filterTrainData();
        createListOfDocument();
    }

    public void getLinesAndStationsDataList(String station){
        filtering = new Filtering(operableCollection);
        dataIterable = filtering.searchStationNameList(station);
        createListOfDocument();
    }

    private void createListOfDocument(){
        List<Document> listOfDocument = new ArrayList<>();
        for (Document document : dataIterable) {
            listOfDocument.add(document);
        }
        listForReturn = listOfDocument;
        closeDb();
    }

    private void closeDb(){
        dbSettings.closeDb();
    }
}
