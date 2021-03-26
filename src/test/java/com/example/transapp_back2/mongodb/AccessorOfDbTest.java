package com.example.transapp_back2.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccessorOfDbTest {

    private DbSettingsForTest dbSettings;
    private static String dbCollection;

    @BeforeAll
    static void setUpStatic(){
        dbCollection = "test";
    }

    @BeforeEach
    public void setUp(){
        dbSettings = new DbSettingsForTest();
    }


    @Test
    public void setDatabaseTest(){
        String result = dbSettings.getDbCollection(dbCollection);
        assertEquals("test", result);
    }

    /*
    @Test
    public void FindFromDbTest(){
       FindIterable<Document> findIterable = ;
        String findIterableToString = findIterable.toString();
        assertTrue(setUpResultToString.startsWith("com.mongodb.client.internal.FindIterableImpl"));
    }

     */

    @Test
    public void closeMongoDbTest(){
        String result = dbSettings.getCloseDbResult();
        assertEquals("closed", result);
    }
}
