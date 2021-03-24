package com.example.transapp_back2.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

class DbSettingsForActual implements DbSettings {
    private Database database;
    private MongoDbSettings mongoDbSettings;
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
        mongoDbSettings = new MongoDbSettingsForActual(database);
        mongoDbSettings.getDataFromDb();
        setUpResult = mongoDbSettings.setUpMongoDb();
    }

    public void closeDb(){
        mongoDbSettings.closeMongoDb();
    }
}
