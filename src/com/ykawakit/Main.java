package com.ykawakit;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Main {
    private static final String OUTPUT_FILE = "simulation.txt";
    public static void main(String[] args) {
        String inputFileName;
        int simulation;
        List<Flyable> aircraft_array;
        if (args.length <= 0) {
            System.out.println("Please specify the input file name.");
            return ;
        } else if (args.length > 1) {
            System.out.println("Program will take exactly one argument. Please try again.");
            return ;
        } else {
            inputFileName = args[0];
        }

        try {
            FileParser fileParser = new FileParser(inputFileName);
            simulation = fileParser.getSimulationCount();
            aircraft_array = fileParser.getAircraftArray();
            PrintStream fileOut = new PrintStream(new FileOutputStream(OUTPUT_FILE));
            System.setOut(fileOut);
        } catch (Exception e) {
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