package com.example.transapp_back2.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MongoDbSettingsTest {

    private MongoDbSettingsForTest mongoDbSettings;
    private static String dbName;
    private static String dbCollection;
    private static String connectionURL;
    private static ConnectionString connectionString;
    private static MongoClientSettings mongoClientSettings;
    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;

    @BeforeAll
    static void setUpStatic(){
        dbName = "transapp";
        dbCollection = "test";
        connectionURL = "mongodb+srv://yuuki:yuukidb@cluster0.wdfqa.mongodb.net/transapp?retryWrites=true&w=majority";
        connectionString = new ConnectionString(connectionURL);
        mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
                .retryWrites(true).build();
        mongoClient = MongoClients.create(mongoClientSettings);
        mongoDatabase = mongoClient.getDatabase(dbName);
    }

    @BeforeEach
    public void setUp(){
        mongoDbSettings = new MongoDbSettingsForTest();
    }

    @Test
    public void createConnectionStringTest(){
        ConnectionString connectionStringForTest = mongoDbSettings.getConnectionString(connectionURL);
        String connectionStringToString = connectionStringForTest.toString();
        assertEquals(
                "mongodb+srv://yuuki:yuukidb@cluster0.wdfqa.mongodb.net/transapp?retryWrites=true&w=majority",
                connectionStringToString);
    }

    @Test
    public void setMongoClientSettingsTest(){
        MongoClientSettings mongoClientSettingsForTest = mongoDbSettings.getMongoClientSettings(connectionString);
        String mongoClientSettingsToString = mongoClientSettingsForTest.toString();
        assertTrue(mongoClientSettingsToString.startsWith("com.mongodb.MongoClientSettings"));
    }

    @Test
    public void createMongoClientTest(){
        MongoClient mongoClientForTest = mongoDbSettings.getMongoClient(mongoClientSettings);
        String mongoClientToString = mongoClientForTest.toString();
        assertTrue(mongoClientToString.startsWith("com.mongodb.client.internal.MongoClientImpl"));
    }

    @Test
    public void createMongoDataBaseTest(){
        MongoDatabase mongoDatabaseForTest = mongoDbSettings.getMongoDatabase(mongoClient, dbName);
        String mongoDatabaseToString = mongoDatabaseForTest.toString();
        assertTrue(mongoDatabaseToString.startsWith("com.mongodb.client.internal.MongoDatabaseImpl"));
    }

    @Test
    public void createMongoCollectionTest(){
        MongoCollection<Document> mongoCollectionForTest = mongoDbSettings.getMongoCollection(mongoDatabase, dbCollection);
        String mongoCollectionToString = mongoCollectionForTest.toString();
        assertTrue(mongoCollectionToString.startsWith("com.mongodb.client.internal.MongoCollectionImpl"));
    }

    @Test
    public void closeMongoDbTest(){
        String result = mongoDbSettings.closeDbTest(mongoClient);
        assertEquals("closed", result);
    }
}
