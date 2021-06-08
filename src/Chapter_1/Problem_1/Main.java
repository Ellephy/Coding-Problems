package Chapter_1.Problem_1;

import java.util.Arrays;
import java.util.Map;

import static Helpers.Helpers.displayExecutionTime;

public class Main {

    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";

    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {
        System.out.println("Input text: \n" + TEXT);
        System.out.println("\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");
        System.out.println("HashMap based solution:");

        long startTimeV1 = System.nanoTime();
        Map<Character, Integer> duplicatesV1 = Strings.countDuplicateCharactersV1(TEXT);
        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println(Arrays.toString(duplicatesV1.entrySet().toArray()));

        long startTimeV2 = System.nanoTime();
        Map<Character, Long> duplicatesV2 = Strings.countDuplicateCharactersV2(TEXT);
        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println(Arrays.toString(duplicatesV2.entrySet().toArray()));

        System.out.println("\n--------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_CP + "\n");
        System.out.println("Including Unicode surrogate pairs examples:\n");
        System.out.println("HashMap based solution:");

        long startTimeV3 = System.nanoTime();
        Map<String, Integer> duplicatesV3 = Strings.countDuplicateCharactersVCP1(TEXT_CP);
        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println(Arrays.toString(duplicatesV3.entrySet().toArray()));

        long startTimeV4 = System.nanoTime();
        Map<String, Long> duplicatesV4 = Strings.countDuplicateCharactersVCP2(TEXT_CP);
        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println(Arrays.toString(duplicatesV4.entrySet().toArray()));
    }
}
