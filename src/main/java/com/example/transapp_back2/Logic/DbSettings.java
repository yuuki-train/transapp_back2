package com.example.transapp_back2.Logic;

import com.example.transapp_back2.entity.DataBase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class DbSettings {

    private DataBase dataBase;
    private MongoDbSettings mongoDbSettings;

    public MongoCollection<Document> setupDb(String dbCollection){
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

    public void closeDb(){
        mongoDbSettings.closeMongoDb();
    }
}
