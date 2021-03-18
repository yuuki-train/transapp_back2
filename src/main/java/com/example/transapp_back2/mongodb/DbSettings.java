package com.example.transapp_back2.mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

class DbSettings {

    private DataBase dataBase;
    private MongoDbSettings mongoDbSettings;

    MongoCollection<Document> setupDb(String dbCollection){
        setDataBase(dbCollection);
        return setupMongoDb();
    }

    private void setDataBase(String dbCollection){
        dataBase = new DataBase();
        dataBase.setDataBaseCollection(dbCollection);
    }

    private MongoCollection<Document> setupMongoDb(){
        mongoDbSettings = new MongoDbSettings(dataBase);
        return mongoDbSettings.setupMongoDB();
    }

    void closeDb(){
        mongoDbSettings.closeMongoDb();
    }
}
