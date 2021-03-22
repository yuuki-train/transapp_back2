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
        FindIterable<Document> dataIterable = filtering.filterTrainData();
        createListOfDocument(dataIterable);
    }

    public void getLinesAndStationsDataList(String station){
        filtering = new Filtering(operableCollection);
        FindIterable<Document> dataIterable = filtering.searchStationNameList(station);
        createListOfDocument(dataIterable);
    }

    private void createListOfDocument(FindIterable<Document> dataIterable){
        List<Document> listOfDocument = addListOfDocument(dataIterable);
        writeListForReturn(listOfDocument);
    }

    private List<Document> addListOfDocument(FindIterable<Document> dataIterable){
        List<Document> listForResult = new ArrayList<>();
        for (Document document : dataIterable) {
            listForResult.add(document);
        }
        return listForResult;
    }

    private void writeListForReturn(List<Document> listOfDocument){
        listForReturn = listOfDocument;
    }

    public void closeDb(){
        dbSettings.closeDb();
    }
}
