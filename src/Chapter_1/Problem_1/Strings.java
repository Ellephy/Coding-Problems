package Chapter_1.Problem_1;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Strings {

    private Strings() {
        throw new AssertionError("Can not be instantiated.");
    }

    public static @NotNull
    Map<Character, Integer> countDuplicateCharactersV1(String str) {
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str) {
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }

        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

    public static Map<String, Integer> countDuplicateCharactersVCP1(String str) {
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            /*int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));

            if (Character.charCount(cp) == 2) {
                i++;
            }*/

            String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                ++i;
            }
            result.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        return result;
    }

    public static Map<String, Long> countDuplicateCharactersVCP2(String str) {
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }

        Map<String, Long> result = str.codePoints()
                .mapToObj(ch -> String.valueOf(Character.toChars(ch)))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        return result;
    }
}
