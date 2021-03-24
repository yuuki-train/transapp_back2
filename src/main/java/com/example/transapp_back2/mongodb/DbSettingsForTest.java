package com.example.transapp_back2.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

class DbSettingsForTest implements DbSettings {
    private Database dataBase;
    private MongoDbSettingsForTest mongoDbSettings;
    private MongoCollection<Document> setUpResult;


    public MongoCollection<Document> setUpDb(String dbCollection){
        setDatabase(dbCollection);
        setUpMongoDb();
        return setUpResult;
    }

    private void setDatabase(String dbCollection){
        dataBase = new Database();
        dataBase.setDatabaseCollection(dbCollection);
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
        return dataBase.getDatabaseCollection();
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
