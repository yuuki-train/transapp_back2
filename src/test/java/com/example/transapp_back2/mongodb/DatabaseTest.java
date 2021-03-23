package com.example.transapp_back2.mongodb;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    private Database dataBase;

    @BeforeEach
    public void setUp(){
        dataBase = new Database();
    }

    @Test
    public void getDataBaseNameTest(){
        String dataBaseName = dataBase.getDatabaseName();
        assertEquals("transapp",dataBaseName);
    }

    @Test
    public void setDataBaseCollectionTest(){
        String collectionName = "test";
        dataBase.setDatabaseCollection(collectionName);
        String gettingCollectionName = dataBase.getDatabaseCollection();
        assertEquals("test",gettingCollectionName);
    }

    @Test
    public void getConnectionURLTest(){
        String connectionURL = dataBase.getConnectionURL();
        assertEquals(
                "mongodb+srv://yuuki:yuukidb@cluster0.wdfqa.mongodb.net/transapp?retryWrites=true&w=majority",
                connectionURL);
    }
}
