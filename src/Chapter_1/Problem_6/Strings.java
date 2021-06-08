package Chapter_1.Problem_6;

public class Strings {

    private Strings() {
        throw new AssertionError("Can not be instantiated!");
    }

    public static int countOccurrencesOfACertainCharacterV1(String str, char ch) {
        if (str == null || str.isBlank())
            return -1;

        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static int countOccurrencesOfACertainCharacterV2(String str, char ch) {
        if (str == null || str.isBlank())
            return -1;

        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (ch == str.charAt(i))
                ++count;

        return count;
    }

    public static long countOccurrencesOfACertainCharacterV3(String str, char ch) {
        if (str == null || str.isBlank())
            return -1;

        return str.chars().filter(c -> c == ch).count();
    }

    public static int countOccurrencesOfACertainCharacterVCP1(String str, String ch) {
        if (str == null || ch == null || str.isBlank() || ch.isBlank() || ch.codePointCount(0, ch.length()) > 1)
            return -1;

        int result = str.length() - str.replace(ch, "").length();

        return ch.length() == 2 ? result / 2 : result;
    }

    public static int countOccurrencesOfACertainCharacterVCP2(String str, String ch) {
        if (str == null || ch == null || str.isBlank() || ch.isBlank() || ch.codePointCount(0, ch.length()) > 1)
            return -1;

        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (ch.codePointAt(0) == str.codePointAt(i))
                ++count;

        return count;
    }

    public static long countOccurrencesOfACertainCharacterVCP3(String str, String ch) {
        if (str == null || ch == null || str.isBlank() || ch.isBlank() || ch.codePointCount(0, ch.length()) > 1)
            return -1;

        int codePoint = ch.codePointAt(0);

        return str.codePoints().filter(cd -> cd == codePoint).count();
    }
}
