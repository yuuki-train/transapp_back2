package com.example.transapp_back2.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

class MongoDbSettings {

    private final String dbName;
    private final String dbCollection;
    private final String connectionURL;
    private ConnectionString connectionString;
    private MongoClient client;

    MongoDbSettings(DataBase database){
        dbName = database.getDataBaseName();
        dbCollection = database.getDataBaseCollection();
        connectionURL = database.getConnectionURL();
    }

    MongoCollection<Document> setupMongoDB(){
        connectionString = new ConnectionString(connectionURL);
        MongoClientSettings mongoClientSettings = setMongoClientSettings();
        return accessMongoDBCollections(mongoClientSettings);
    }

    private MongoClientSettings setMongoClientSettings (){
        return MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .build();
    }

    private MongoCollection<Document> accessMongoDBCollections(MongoClientSettings mongoClientSettings)  {
        client = MongoClients.create(mongoClientSettings);
        MongoDatabase database = client.getDatabase(dbName);
        return database.getCollection(dbCollection);
    }

    void closeMongoDb(){
        client.close();
    }
}
