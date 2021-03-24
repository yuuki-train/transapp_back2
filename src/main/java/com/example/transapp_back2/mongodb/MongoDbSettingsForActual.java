package com.example.transapp_back2.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

class MongoDbSettingsForActual implements MongoDbSettings {

    private final Database database;
    private String dbName;
    private String dbCollection;
    private String connectionURL;
    private ConnectionString connectionString;
    private MongoClientSettings mongoClientSettings;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;

    public MongoDbSettingsForActual(Database database){
        this.database = database;
    }

    public void getDataFromDb(){
        dbName = database.getDatabaseName();
        dbCollection = database.getDatabaseCollection();
        System.out.println(dbCollection);
        connectionURL = database.getConnectionURL();
    }

    public MongoCollection<Document> setUpMongoDb(){
        createConnectionString();
        setMongoClientSettings();
        createMongoClient();
        createMongoDatabase();
        createMongoCollection();
        return mongoCollection;
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

    private void createMongoClient() {
        mongoClient =  MongoClients.create(mongoClientSettings);
    }

    private void createMongoDatabase(){
        mongoDatabase = mongoClient.getDatabase(dbName);
    }

    private void createMongoCollection(){
        mongoCollection = mongoDatabase.getCollection(dbCollection);
    }

    public void closeMongoDb(){
        mongoClient.close();
    }
}
