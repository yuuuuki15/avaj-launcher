package com.ykawakit;

public class ArgumentManager {
    private ArgumentManager() {
    }

    public static String getInputFileName(String[] args) throws InvalidArgumentException {
        if (args.length <= 0) {
            throw new InvalidArgumentException("Please specify the input file name.");
        } else if (args.length > 1) {
            throw new InvalidArgumentException("Program will take exactly one argument. ");
        } else {
            return args[0];
        }
    }
}
