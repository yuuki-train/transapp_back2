package com.example.transapp_back2.businesslogic;

import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicForFindLinesTest{

    private LogicForFindLines logicForFindLines;
    private String departure;
    private String destination;

    @BeforeEach
    private void setUp(){
        departure = "天王寺";
        destination = "新今宮";
    }

    @Test
    public void findLines(){
        logicForFindLines = new LogicForFindLines(departure, destination);
        List<Document> list = logicForFindLines.findLines();
        List<String> stationsOfLine =(List<String>) list.get(0).get("stationsOfLine");
        assertEquals("東三国" , stationsOfLine.get(1));
    }


}
