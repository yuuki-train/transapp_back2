package com.example.transapp_back2.entity;

import org.bson.types.ObjectId;

import java.util.List;

public class LinesAndStations {

    private ObjectId _id;
    private String lineName;
    private List<String> stationsOfLine;
    private List<String> connectingLines;
}
