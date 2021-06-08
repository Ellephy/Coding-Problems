package Chapter_1.Problem_4;

public class Strings {

    private Strings() {
        throw new AssertionError("Can not be instantiated!");
    }

    public static boolean containsOnlyDigitsV1(String str) {
        if (str == null || str.isBlank())
            return false;

        for (char ch : str.toCharArray())
            if (!Character.isDigit(ch))
                return false;

        return true;
    }

    public static boolean containsOnlyDigitsV2(String str) {
        // or throw IllegalArgumentException
        if (str == null || str.isBlank())
            return false;

        //return !str.chars().anyMatch(ch -> !Character.isDigit(ch));
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean containsOnlyDigitsV3(String str) {
        // or throw IllegalArgumentException
        if (str == null || str.isBlank())
            return false;

        return str.matches("[0-9]+");
    }
}
