package com.example.transapp_back2.entity;

public class DataBase {
    private final String userName;
    private final String userPass;
    private final String dataBaseName;
    private String dataBaseCollection;

    public DataBase(){
        this.userName = "yuuki";
        this.userPass = "yuukidb";
        this.dataBaseName = "transapp";
    }

    public String getDataBaseName(){
        return dataBaseName;
    }

    public String getDataBaseCollection(){
        return dataBaseCollection;
    }

    public void setDataBaseCollection(String dbCollection){
        this.dataBaseCollection = dbCollection;
    }

    public String getConnectionURL(){
        return "mongodb+srv://" + userName + ":" + userPass +
                "@cluster0.wdfqa.mongodb.net/" + dataBaseName + "?retryWrites=true&w=majority";
    }
}
