package com.example.transapp_back2.mongodb;

import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccessorOfDbTest {

    private AccessorOfDb accessorOfDb;
    private String station;



    @BeforeEach
    private void setUp(){
        station = "新今宮";
    }

    @Test
    public void getTrainDataForSearchTest(){
        accessorOfDb = new AccessorOfDb("TrainsOfMidosuji");
        List<Document> list = accessorOfDb.getTrainDataForSearch();
        assertEquals(1, list.size());
    }

    @Test
    public void getLinesAndStationsDataTest(){
        accessorOfDb = new AccessorOfDb("LinesAndStations");
        List<Document> list = accessorOfDb.getLinesAndStationsData(station);
        assertEquals(2, list.size());
    }


}