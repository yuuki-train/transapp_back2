package com.example.transapp_back2.mongodb;

class DataBase {
    private final String userName;
    private final String userPass;
    private final String dataBaseName;
    private String dataBaseCollection;

    DataBase(){
        this.userName = "yuuki";
        this.userPass = "yuukidb";
        this.dataBaseName = "transapp";
    }

    String getDataBaseName(){
        return dataBaseName;
    }

    String getDataBaseCollection(){
        return dataBaseCollection;
    }

    void setDataBaseCollection(String dbCollection){
        this.dataBaseCollection = dbCollection;
    }

    String getConnectionURL(){
        return "mongodb+srv://" + userName + ":" + userPass +
                "@cluster0.wdfqa.mongodb.net/" + dataBaseName + "?retryWrites=true&w=majority";
    }
}
