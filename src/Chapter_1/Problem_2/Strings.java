package Chapter_1.Problem_2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Strings {

    // http://www.alansofficespace.com/unicode/unicd99.htm
    private static final int EXTENDED_ASCII_CODES = 256; // can be increased to 65535

    private Strings() {
        throw new AssertionError("Can not be instantiated.");
    }

    public static char firstNonRepeatedCharacterV1(String str) {
        if (str == null || str.isBlank()) {
            return Character.MIN_VALUE;
        }

        //List<Character> chList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            /*if (!chList.contains(ch)) {
                chList.add(ch);
            } else {
                continue;
            }*/

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (ch == str.charAt(j) && i != j) {
                    ++count;
                    break;
                }
            }

            if (count == 0) return ch;
        }
        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV2(String str) {
        if (str == null || str.isBlank()) {
            return Character.MIN_VALUE;
        }

        int[] flags = new int[EXTENDED_ASCII_CODES];
        Arrays.fill(flags, -1);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (flags[ch] == -1)
                flags[ch] = i;
            else
                flags[ch] = -2;

        }

        int position = Character.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0)
                position = Math.min(position, flags[i]);
        }

        return position == Character.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    public static char firstNonRepeatedCharacterV3(String str) {
        if (str == null || str.isBlank()) {
            return Character.MIN_VALUE;
        }

        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            chars.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV4(String str) {
        if (str == null || str.isBlank())
            return Character.MIN_VALUE;

        Map<Integer, Long> chars = str.chars()
                .boxed() // mapToObject(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        return (char) (int) chars.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);
    }

    public static String firstNonRepeatedCharacterVCP4(String str) {
        if (str == null || str.isBlank())
            return String.valueOf(Character.MIN_VALUE);

        Map<Integer, Long> chars = str.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chars.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        return String.valueOf(Character.toChars(cp));
    }
}
