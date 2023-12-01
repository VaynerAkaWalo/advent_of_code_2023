package com.adventofcode.day01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class SolutionPart2 {

    private static final Logger logger = Logger.getLogger(SolutionPart2.class.getName());
    private static final Map<String, Integer> numbers = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("./src/main/java/com/adventofcode/day01/input"));
        int counter = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            counter += find(line);
        }

        logger.info("Poszukiwana liczba to: %d".formatted(counter));
    }

    private static int find(String line) {
        int low, high;

        int index = 0;
        while ((low = check(line, index)) == -1) index++;
        index = line.length() - 1;

        while ((high = check(line, index)) == -1) index--;

        return low * 10 + high;
    }

    private static int check(String line, int index) {
        char current = line.charAt(index);
        if (Character.isDigit(current)) return Character.digit(current, 10);

        for (String s : numbers.keySet()) {
            if (line.startsWith(s, index)) return numbers.get(s);
        }

        return -1;
    }
}
