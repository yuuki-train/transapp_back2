package com.example.transapp_back2.mongodb;

import org.bson.Document;

import java.util.List;

public interface AccessorOfDb {
    void setDbPreparation(String collectionName);
    void getTrainDataList();
    void getLinesAndStationsDataList(String station);
    void findFromDb(List<String> searchFilter);
    List<Document> getTrainDataForSearch();
    List<Document> getLinesAndStationsData(String station);
}
