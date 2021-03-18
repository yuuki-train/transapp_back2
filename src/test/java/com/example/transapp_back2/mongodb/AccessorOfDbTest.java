package com.example.transapp_back2.mongodb;

import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccessorOfDbTest {

    private AccessorOfDb accessorOfDb;
    //private Method method;

    @BeforeEach
    private void setUp(){
        accessorOfDb = new AccessorOfDb("TrainsOfMidosuji");
    }

    @Test
    public void getTrainDataForSearch(){
        List<Document> list = accessorOfDb.getTrainDataForSearch();
        assertEquals(1, list.size());
    }

    /*
    @Test
    public void getMongoCollection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        method = SearchDAO.class.getDeclaredMethod("getMongoCollection");
        method.setAccessible(true);
        MongoCollection<Document>collection = (MongoCollection<Document>)method.invoke(searchDAO);

        assert()

    }
    */


}
