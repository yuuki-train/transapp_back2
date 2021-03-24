package com.example.transapp_back2.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

class DbSettingsForTest implements DbSettings {
    private Database database;
    private MongoDbSettingsForTest mongoDbSettings;
    private MongoCollection<Document> setUpResult;


    public MongoCollection<Document> setUpDb(String dbCollection){
        setDatabase(dbCollection);
        setUpMongoDb();
        return setUpResult;
    }

    private void setDatabase(String dbCollection){
        database = new Database();
        database.setDatabaseCollection(dbCollection);
    }

    private void setUpMongoDb(){
        mongoDbSettings = new MongoDbSettingsForTest();
        mongoDbSettings.getDataFromDb();
        setUpResult = mongoDbSettings.setUpMongoDb();
    }

    public void closeDb(){
        mongoDbSettings.closeMongoDb();
    }

    String getDbCollection(String dbCollection){
        setDatabase(dbCollection);
        return database.getDatabaseCollection();
    }

    MongoCollection<Document> getSetUpResult(){
        setUpMongoDb();
        return setUpResult;
    }

    String getCloseDbResult(){
        setUpMongoDb();
        closeDb();
        return "closed";
    }
}
