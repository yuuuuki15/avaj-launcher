package com.ykawakit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    String filename;
    int simulationCount;
    List<Aircraft> aircrafts = new ArrayList<>();

    FileParser(String filename) {
        this.filename = filename;

        try (BufferedReader reader = new BufferedReader(new FileReader(this.filename))){
            String line;

            line = reader.readLine();
            this.simulationCount = Integer.parseInt(line);

            while ((line = reader.readLine()) != null) {
                String[] array = line.split(" ");
                if (array.length != 5) {
                    System.out.println("wrong scenario.");
                    throw new Exception("Wrong scenario.");
                }
                String type = array[0];
                String name = array[1];
                int longitude = Integer.parseInt(array[2]);
                int latitude = Integer.parseInt(array[3]);
                int height = Integer.parseInt(array[4]);

                Aircraft aircraft = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
                if (aircraft != null) {
                    this.aircrafts.add(aircraft);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading a file: " + this.filename);
        } catch (Exception e) {
            System.out.println("Something happened." +  e.getMessage());
        }
    }

    public int getSimulationCount() {
        return this.simulationCount;
    }

    public List<Aircraft> getAircrafts() {
        return this.aircrafts;
    }
}
