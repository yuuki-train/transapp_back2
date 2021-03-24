package com.example.transapp_back2.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

class DbSettingsForActual implements DbSettings {

    private MongoDbSettings mongoDbSettings;
    private MongoCollection<Document> setUpResult;

    public MongoCollection<Document> setUpDb(String dbCollection){
        setDatabase(dbCollection);
        setUpMongoDb();
        return setUpResult;
    }

    private void setDatabase(String dbCollection){
        Database database = new Database();
        database.setDatabaseCollection(dbCollection);
    }

    private void setUpMongoDb(){
        mongoDbSettings.getDataFromDb();
        setUpResult = mongoDbSettings.setUpMongoDb();
    }

    public void closeDb(){
        mongoDbSettings.closeMongoDb();
    }
}
