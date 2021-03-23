package com.example.transapp_back2.mongodb;

class Database {
    private final String userName;
    private final String userPass;
    private final String dataBaseName;
    private String dataBaseCollection;

    Database(){
        this.userName = "yuuki";
        this.userPass = "yuukidb";
        this.dataBaseName = "transapp";
    }

    String getDatabaseName(){
        return dataBaseName;
    }

    String getDatabaseCollection(){
        return dataBaseCollection;
    }

    void setDatabaseCollection(String dbCollection){
        this.dataBaseCollection = dbCollection;
    }

    String getConnectionURL(){
        return "mongodb+srv://" + userName + ":" + userPass +
                "@cluster0.wdfqa.mongodb.net/" + dataBaseName + "?retryWrites=true&w=majority";
    }
}
