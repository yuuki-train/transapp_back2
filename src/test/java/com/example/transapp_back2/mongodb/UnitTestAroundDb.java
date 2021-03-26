package com.example.transapp_back2.mongodb;

import com.example.transapp_back2.entity.LinesAndStations;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestAroundDb {

    private AccessorOfDb accessorOfDb;
    private String station;
    private FindIterable findIterable;
    private String collectionName;


    @BeforeEach
    private void setUp() {
        station = "天王寺";
        accessorOfDb = new AccessorOfDbForActual();
    }


    @Test
    public void getTrainDataForSearchTest(){
        collectionName = "TrainsOfMidosuji";
        accessorOfDb.setDbPreparation(collectionName);
        List<Document> list = accessorOfDb.getTrainDataForSearch();
        assertEquals(1, list.size());
    }

    @Test
    public void getLinesAndStationsDataTest(){
        collectionName = "LinesAndStations";
        accessorOfDb.setDbPreparation(collectionName);
        List<Document> list = accessorOfDb.getLinesAndStationsData(station);
        assertEquals(4, list.size());
    }


}
