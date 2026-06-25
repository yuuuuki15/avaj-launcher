package com.ykawakit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Simulator {
    private static final String OUTPUT_FILE = "simulation.txt";
    public static void main(String[] args) {
        String inputFileName;
        int simulation;
        List<Flyable> aircraft_array;

        try {
            inputFileName = ArgumentManager.getInputFileName(args);
            FileParser fileParser = new FileParser(inputFileName);
            simulation = fileParser.getSimulationCount();
            aircraft_array = fileParser.getAircraftArray();
            PrintStream fileOut = new PrintStream(new FileOutputStream(OUTPUT_FILE));
            System.setOut(fileOut);
        } catch (ScenarioFileException | InvalidArgumentException | IOException e) {
            System.out.println(e.getMessage());
            return ;
        }

        WeatherTower weatherTower = new WeatherTower();

        for (Flyable aircraft : aircraft_array) {
            weatherTower.register(aircraft);
        }

        for (int i = 0; i < simulation; i++) {
            weatherTower.changeWeather();
        }
    }
}