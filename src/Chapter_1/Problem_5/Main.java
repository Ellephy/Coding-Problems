package Chapter_1.Problem_5;

import static Helpers.Helpers.displayExecutionTime;

public class Main {
    // 14 vowels, 19 consonants
    private static final String TEXT = " ... Illinois Mathematics & Science Academy ... ";

    public static void main(String[] args) {
        System.out.println("Input text: \n" + TEXT + "\n");
        System.out.println("String.charAt() solution:");

        long startTimeV1 = System.nanoTime();
        Pair<Integer, Integer> pairV1 = Strings.countVowelsConsonantsV1(TEXT);
        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Vowels: " + pairV1.vowels);
        System.out.println("Consonants: " + pairV1.consonants);

        System.out.println();
        System.out.println("Java 8, functional-style solution 1:");

        long startTimeV2 = System.nanoTime();
        Pair<Long, Long> pairV2 = Strings.countVowelsConsonantsV2(TEXT);
        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Vowels: " + pairV2.vowels);
        System.out.println("Consonants: " + pairV2.consonants);

        System.out.println();
        System.out.println("Java 8, functional-style solution 2:");

        long startTimeV3 = System.nanoTime();
        Pair<Long, Long> pairV3 = Strings.countVowelsConsonantsV3(TEXT);
        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Vowels: " + pairV3.vowels);
        System.out.println("Consonants: " + pairV3.consonants);
    }
}
