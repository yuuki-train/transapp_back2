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
    private ConnectionString connectionString;
    private MongoClientSettings mongoClientSettings;
    private MongoClient mongoClient;

    @BeforeAll
    static void setUpStatic(){
        dbName = "transapp";
        dbCollection = "test";
        connectionURL = "mongodb+srv://yuuki:yuukidb@cluster0.wdfqa.mongodb.net/transapp?retryWrites=true&w=majority";
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
        connectionString = new ConnectionString(connectionURL);
        MongoClientSettings mongoClientSettingsForTest = mongoDbSettings.getMongoClientSettings(connectionString);
        String mongoClientSettingsToString = mongoClientSettingsForTest.toString();
        assertTrue(mongoClientSettingsToString.startsWith("com.mongodb.MongoClientSettings"));
    }

    @Test
    public void createMongoClientTest(){
        connectionString = new ConnectionString(connectionURL);
        mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).retryWrites(true).build();
        MongoClient mongoClientForTest = mongoDbSettings.getMongoClient(mongoClientSettings);
        String mongoClientToString = mongoClientForTest.toString();
        assertTrue(mongoClientToString.startsWith("com.mongodb.client.internal.MongoClientImpl"));
    }

    @Test
    public void createMongoDataBaseTest(){
        connectionString = new ConnectionString(connectionURL);
        mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).retryWrites(true).build();
        mongoClient = MongoClients.create(mongoClientSettings);
        MongoDatabase mongoDatabaseForTest = mongoDbSettings.getMongoDatabase(mongoClient, dbName);
        String mongoDatabaseToString = mongoDatabaseForTest.toString();
        assertTrue(mongoDatabaseToString.startsWith("com.mongodb.client.internal.MongoDatabaseImpl"));
    }

    @Test
    public void createMongoCollectionTest(){
        connectionString = new ConnectionString(connectionURL);
        mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).retryWrites(true).build();
        mongoClient = MongoClients.create(mongoClientSettings);
        MongoDatabase database = mongoClient.getDatabase(dbName);
        MongoCollection<Document> mongoCollectionForTest = mongoDbSettings.getMongoCollection(database, dbCollection);
        String mongoCollectionToString = mongoCollectionForTest.toString();
        assertTrue(mongoCollectionToString.startsWith("com.mongodb.client.internal.MongoCollectionImpl"));
    }

    @Test
    public void closeMongoDbTest(){
        connectionString = new ConnectionString(connectionURL);
        mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).retryWrites(true).build();
        mongoClient = MongoClients.create(mongoClientSettings);
        String result = mongoDbSettings.closeDbTest(mongoClient);
        assertEquals("closed", result);
    }
}
