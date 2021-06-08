package Chapter_1.Problem_3;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Strings {
    private Strings() {
        throw new AssertionError("Can not be instantiated!");
    }

    private static final String WHITESPACE = " ";

    public static String reverseWordsV1(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return "";
        }

        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }
            reversedString.append(reversedWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }

    private static final Pattern PATTERN = Pattern.compile(" +");

    public static String reverseWordsV2(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return "";
        }

        return PATTERN.splitAsStream(str)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }

    public static String reverseString(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return "";
        }

        return new StringBuilder(str).reverse().toString();
    }
}
