package com.adventofcode.day02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

public class SolutionPart2 {

    private static final Logger logger = Logger.getLogger(SolutionPart1.class.getName());

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("./src/main/java/com/adventofcode/day02/input"));
        int counter = 0;

        while (scanner.hasNext()) {
            counter += processLine(scanner.nextLine());
        }

        logger.info("Poszukiwana wartość: %d".formatted(counter));
    }

    private static int processLine(String line) {
        String[] parts = line.split(":");
        int gameId = Integer.parseInt(parts[0].substring(parts[0].indexOf(" ") + 1));
        String[] sets = parts[1].split(";");
        int[] max = new int[3];

        for (String set : sets) {
            int[] inSet = processSet(set);
            max[0] = Math.max(max[0], inSet[0]);
            max[1] = Math.max(max[1], inSet[1]);
            max[2] = Math.max(max[2], inSet[2]);
        }

        return max[0] * max[1] * max[2];
    }

    private static int[] processSet(String set) {
        Scanner scanner = new Scanner(set);
        int[] cubes = new int[3];

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            switch (scanner.next()) {
                case "red", "red," -> cubes[0] += num;
                case "green", "green," -> cubes[1] += num;
                case "blue", "blue," -> cubes[2] += num;
            }
        }

        return cubes;
    }
}
