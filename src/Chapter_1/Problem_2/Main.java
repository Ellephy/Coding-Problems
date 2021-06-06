package Chapter_1.Problem_2;

import Helpers.Helpers;

import java.util.concurrent.TimeUnit;

public class Main {
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.'";

    public static void main(String[] args) {
        System.out.println("Input text: \n" + TEXT + "\n");
        System.out.println("ASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");
        System.out.println("Loop and break solution:");

        long startTimeV1 = System.nanoTime();
        char firstcharV1 = Strings.firstNonRepeatedCharacterV1(TEXT);
        Helpers.displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Found character: " + firstcharV1);
    }

}
