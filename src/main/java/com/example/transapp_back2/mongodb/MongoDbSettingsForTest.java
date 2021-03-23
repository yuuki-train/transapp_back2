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
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public void getDataFromDb(){
        dbName = "transapp";
        dbCollection = "test";
        connectionURL = "mongodb+srv://yuuki:yuukidb@cluster0.wdfqa.mongodb.net/transapp?retryWrites=true&w=majority";
    }

    public MongoCollection<Document> setUpMongoDB(){
        createConnectionString();
        setMongoClientSettings();
        createClient();
        createDataBase();
        createCollection();
        System.out.println(collection.toString());
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

    MongoClient getClient(MongoClientSettings mongoClientSettings){
        this.mongoClientSettings = mongoClientSettings;
        createClient();
        return client;
    }

    MongoDatabase getDatabase(MongoClient client, String dbName){
        this.client = client;
        this.dbName = dbName;
        createDataBase();
        return database;
    }
    MongoCollection<Document> getCollection(MongoDatabase database, String dbCollection){
        this.database = database;
        this.dbCollection = dbCollection;
        createCollection();
        return collection;
    }

    String closeDbTest(MongoClient client){
        this.client = client;
        closeMongoDb();
        return "closed";
    }

}
