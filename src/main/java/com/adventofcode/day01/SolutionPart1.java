package com.adventofcode.day01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class SolutionPart1 {
    private static final Logger logger = Logger.getLogger(SolutionPart1.class.getName());
    private static final Predicate<Character> isDigit = Character::isDigit;
    private static final Function<Character, Integer> value = x -> Character.digit(x, 10);

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
        int low = 0;
        int high = line.length() - 1;

        while (!isDigit.test(line.charAt(low))) low++;
        while (!isDigit.test(line.charAt(high))) high--;

        return value.apply(line.charAt(low)) * 10 + value.apply(line.charAt(high));
    }
}
