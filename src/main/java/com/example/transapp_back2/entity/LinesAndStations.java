package com.example.transapp_back2.entity;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class LinesAndStations {

    private ObjectId _id;
    private String lineName;
    private List<String> stationsOfLine;
    private List<String> connectingLines;

    public List<LinesAndStations> setObject(List<Document> listOfDocument){
        return setObjectList(listOfDocument);
    }

    public ObjectId getId(){
        return _id;
    }

    public String getLineName(){
        return lineName;
    }

    public List<String> getStationsOfLine(){
        return stationsOfLine;
    }

    public List<String> getConnectingLines(){
        return connectingLines;
    }


    private void setId (ObjectId _id){
        this._id = _id;
    }

    private void setLineName (String lineName){
        this.lineName = lineName;
    }

    private void setStationsOfLine (List<String> stationsOfLine){
        this.stationsOfLine = stationsOfLine;
    }

    private void setConnectingLines (List<String> connectingLines){
        this.connectingLines = connectingLines;
    }

    private List<LinesAndStations> setObjectList(List<Document> listOfDocument){
        List<LinesAndStations> listForResult = new ArrayList<>();
        for (Document document : listOfDocument) {
            LinesAndStations linesAndStations = new LinesAndStations();
            linesAndStations.setId(document.getObjectId("_id"));
            linesAndStations.setLineName(document.getString("lineName"));
            linesAndStations.setStationsOfLine(document.getList("stationsOfLine", null));
            linesAndStations.setConnectingLines(document.getList("connectingLines", null));
            listForResult.add(linesAndStations);
        }
        return listForResult;

    }

}
