package com.example.transapp_back2.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

class MongoDbSettingsForActual implements MongoDbSettings {

    private String dbName;
    private String dbCollection;
    private String connectionURL;
    private ConnectionString connectionString;
    private MongoClientSettings mongoClientSettings;
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public void getDataFromDb(){
        Database dataBase = new Database();
        dbName = dataBase.getDatabaseName();
        dbCollection = dataBase.getDatabaseCollection();
        connectionURL = dataBase.getConnectionURL();
    }

    public MongoCollection<Document> setUpMongoDb(){
        createConnectionString();
        setMongoClientSettings();
        createClient();
        createDataBase();
        createCollection();
        return collection;
    }

    private void createConnectionString(){
        connectionString = new ConnectionString(connectionURL);
    }

    private void setMongoClientSettings(){
        mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .build();
    }

    private void createClient() {
        client =  MongoClients.create(mongoClientSettings);
    }

    private void createDataBase(){
        database = client.getDatabase(dbName);
    }

    private void createCollection(){
        collection = database.getCollection(dbCollection);
    }

    public void closeMongoDb(){
        client.close();
    }
}
