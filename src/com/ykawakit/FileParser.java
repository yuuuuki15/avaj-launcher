package com.ykawakit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    String filename;
    int simulationCount;
    List<Flyable> aircraft_array = new ArrayList<>();

    FileParser(String filename) throws Exception {
        this.filename = filename;

        BufferedReader reader = new BufferedReader(new FileReader(this.filename));
        String line;

        line = reader.readLine();
        if (line.isEmpty() || !line.matches("^[0-9]+$")){
            throw new Exception("First line of the scenario file should be a positive integer.");
        }
        this.simulationCount = Integer.parseInt(line);
        if (this.simulationCount < 0) {
            throw new Exception("First line of the scenario file should be a positive integer.");
        }

        while ((line = reader.readLine()) != null) {
            String[] array = line.split(" ");
            if (array.length != 5) {
                throw new Exception("Wrong format. Use this instead: TYPE NAME LONGITUDE LATITUDE HEIGHT");
            }
            String type = array[0];
            if (!type.matches("Balloon|JetPlane|Helicopter")) {
                throw new Exception("Unknown aircraft type: " + type);
            }
            String name = array[1];
            if (!array[2].matches("^[0-9]+$") || !array[3].matches("^[0-9]+$") || !array[4].matches("^[0-9]+$")) {
                throw new Exception("Coordinates should be positive integers.");
            }
            int longitude = Integer.parseInt(array[2]);
            int latitude = Integer.parseInt(array[3]);
            int height = Integer.parseInt(array[4]);

            Flyable aircraft = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
            if (aircraft != null) {
                this.aircraft_array.add(aircraft);
            }
        }
    }

    public int getSimulationCount() {
        return this.simulationCount;
    }

    public List<Flyable> getAircraftArray() {
        return this.aircraft_array;
    }
}
