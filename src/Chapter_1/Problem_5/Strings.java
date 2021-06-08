package Chapter_1.Problem_5;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class Strings {

    private Strings() {
        throw new AssertionError("Can not be instantiated!");
    }

    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static Pair<Integer, Integer> countVowelsConsonantsV1(String str) {
        if (str == null || str.isBlank()) {
            return Pair.of(-1, -1);
        }

        str = str.toLowerCase();

        int vowelsCount = 0;
        int consonantsCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                ++vowelsCount;
            } else if (ch >= 'a' && ch <= 'z') {
                ++consonantsCount;
            }
        }
        return Pair.of(vowelsCount, consonantsCount);
    }

    public static Pair<Long, Long> countVowelsConsonantsV2(String str) {
        if (str == null || str.isBlank()) {
            return Pair.of(-1L, -1L);
        }

        str = str.toLowerCase(Locale.ROOT);

        long vowelsCount = str.chars()
                .filter(v -> allVowels.contains((char) v))
                .count();

        long consonantsCount = str.chars()
                .filter(v -> !allVowels.contains((char) v))
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .count();

        return Pair.of(vowelsCount, consonantsCount);
    }

    public static Pair<Long, Long> countVowelsConsonantsV3(String str) {
        if (str == null || str.isBlank()) {
            return Pair.of(-1L, -1L);
        }

        Map<Boolean, Long> result = str.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .collect(partitioningBy(allVowels::contains, counting()));

        return Pair.of(result.get(true), result.get(false));
    }
}
