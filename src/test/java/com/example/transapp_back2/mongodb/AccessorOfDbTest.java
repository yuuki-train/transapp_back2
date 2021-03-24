package com.example.transapp_back2.mongodb;

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

    @Test
    public void setUpMongoDbTest(){
        MongoCollection<Document> setUpResult = dbSettings.getSetUpResult();
        String setUpResultToString = setUpResult.toString();
        assertTrue(setUpResultToString.startsWith("com.mongodb.client.internal.MongoCollectionImpl"));
    }

    @Test
    public void closeMongoDbTest(){
        String result = dbSettings.getCloseDbResult();
        assertEquals("closed", result);
    }
}
