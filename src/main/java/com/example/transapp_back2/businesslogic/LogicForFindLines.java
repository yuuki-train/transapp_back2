package com.example.transapp_back2.businesslogic;

import com.example.transapp_back2.mongodb.AccessorOfDbForActual;
import org.bson.Document;

import java.util.List;

public class LogicForFindLines {

    private final String departure;
    private final String destination;
    private List<Document> linesOfDepartStation;
    private List<Document> linesOfArriveStation;
    private final AccessorOfDbForActual accessorOfDb;

    public LogicForFindLines(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
        accessorOfDb = new AccessorOfDbForActual();
    }


    public List<Document> findLines () {
        getLinesOfStations();
        return linesOfDepartStation;
    }

    private void getLinesOfStations(){
        linesOfDepartStation = accessorOfDb.getLinesAndStationsData(departure);
        linesOfArriveStation = accessorOfDb.getLinesAndStationsData(destination);
        accessorOfDb.closeDb();
    }

    private void checkSameLines(){




    }


}
