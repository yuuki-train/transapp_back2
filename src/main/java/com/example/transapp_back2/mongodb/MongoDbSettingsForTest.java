package com.example.transapp_back2.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

class MongoDbSettingsForTest implements MongoDbSettings {

    private String dbName;
    private String dbCollection;
    private String connectionURL;
    private ConnectionString connectionString;
    private MongoClientSettings mongoClientSettings;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;

    public void getDataFromDb(){
        dbName = "transapp";
        dbCollection = "test";
        connectionURL = "mongodb+srv://yuuki:yuukidb@cluster0.wdfqa.mongodb.net/transapp?retryWrites=true&w=majority";
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

    ConnectionString getConnectionString(String connectionURL){
        this.connectionURL = connectionURL;
        createConnectionString();
        return connectionString;
    }

    MongoClientSettings getMongoClientSettings(ConnectionString connectionString){
        this.connectionString = connectionString;
        setMongoClientSettings();
        return mongoClientSettings;
    }

    MongoClient getMongoClient(MongoClientSettings mongoClientSettings){
        this.mongoClientSettings = mongoClientSettings;
        createMongoClient();
        return mongoClient;
    }

    MongoDatabase getMongoDatabase(MongoClient mongoClient, String dbName){
        this.mongoClient = mongoClient;
        this.dbName = dbName;
        createMongoDatabase();
        return mongoDatabase;
    }
    MongoCollection<Document> getMongoCollection(MongoDatabase mongoDatabase, String dbCollection){
        this.mongoDatabase = mongoDatabase;
        this.dbCollection = dbCollection;
        createMongoCollection();
        return mongoCollection;
    }

    String closeDbTest(MongoClient client){
        this.mongoClient = client;
        closeMongoDb();
        return "closed";
    }

}
