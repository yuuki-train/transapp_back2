package com.example.transapp_back2.mongodb;

class DbSettings {

    private Database dataBase;
    private MongoDbSettings mongoDbSettings;

    void setupDb(String dbCollection){
        setDataBase(dbCollection);
        //return setupMongoDb();
    }

    private void setDataBase(String dbCollection){
        dataBase = new Database();
        dataBase.setDatabaseCollection(dbCollection);
    }

    private void setupMongoDb(){
        mongoDbSettings.getDataFromDb();
        mongoDbSettings.setUpMongoDB();
    }

    void closeDb(){
        mongoDbSettings.closeMongoDb();
    }
}
