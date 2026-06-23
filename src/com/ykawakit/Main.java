package com.ykawakit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Main {
    private static final String OUTPUT_FILE = "simulation.txt";
    public static void main(String[] args) {
        String inputFileName;
        if (args.length > 0) {
            inputFileName = args[0];
        } else {
            System.out.println("Please specify the input file name.");
            return ;
        }
        FileParser fileParser = new FileParser(inputFileName);
        int simulation = fileParser.getSimulationCount();
        List<Aircraft> aircraftArray = fileParser.getAircrafts();

        try {
            PrintStream fileOut = new PrintStream(new FileOutputStream(OUTPUT_FILE));
            System.setOut(fileOut);
        } catch (IOException e) {
        }

        WeatherTower weatherTower = new WeatherTower();

        for (Aircraft aircraft : aircraftArray) {
            weatherTower.register(aircraft);
        }

        for (int i = 0; i < simulation; i++) {
            weatherTower.changeWeather();
        }
    }
}