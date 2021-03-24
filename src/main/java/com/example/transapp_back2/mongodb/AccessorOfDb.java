package com.example.transapp_back2.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AccessorOfDb {
    private final String dbCollection;
    private MongoCollection<Document> operableCollection;
    private FindFromDb findFromDb;
    private DbSettingsForActual dbSettings;
    private List<Document> listForReturn;

    //コンストラクタ
    public AccessorOfDb(String collectionName){
        dbCollection = collectionName;
        getMongoCollection();
    }

    private void getMongoCollection(){
        dbSettings = new DbSettingsForActual();
        operableCollection = dbSettings.setUpDb(dbCollection);
    }

    //publicメソッド
    public List<Document> getTrainDataForSearch(){
        getTrainDataList();
        return listForReturn;
    }

    public List<Document> getLinesAndStationsData(String station){
        getLinesAndStationsDataList(station);
        return listForReturn;
    }



    private void getTrainDataList (){
        findFromDb = new FindFromDb(operableCollection);
        FindIterable<Document> dataIterable = findFromDb.filterTrainData();
        System.out.println(dataIterable);
        createListOfDocument(dataIterable);
    }

    public void getLinesAndStationsDataList(String station){
        findFromDb = new FindFromDb(operableCollection);
        FindIterable<Document> dataIterable = findFromDb.searchStationNameList(station);
        System.out.println(dataIterable);
        createListOfDocument(dataIterable);
    }


    public void findFromDb(List<String> searchFilter){
        findFromDb = new FindFromDb(operableCollection);
        FindIterable<Document> dataIterable = findFromDb.findDataFromDb(searchFilter);
        createListOfDocument(dataIterable);
    }


    private void createListOfDocument(FindIterable<Document> dataIterable){
        List<Document> listForResult = new ArrayList<>();
        for (Document document : dataIterable) {
            listForResult.add(document);
        }
        listForReturn = listForResult;
    }

    public void closeDb(){
        dbSettings.closeDb();
    }
}
