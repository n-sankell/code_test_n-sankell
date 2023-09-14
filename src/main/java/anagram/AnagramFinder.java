package anagram;

import java.util.Arrays;

public class AnagramFinder {

    public static boolean isAnagram(String string1, String string2) {
        return checkNull(string1, string2) && hasLength(string1, string2) && sortString(string1.trim()).equals(sortString(string2.trim()));
    }

    private static String sortString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

    private static boolean hasLength(String string1, String string2) {
        return !string1.trim().isEmpty() && !string2.trim().isEmpty();
    }

    private static boolean checkNull(String string1, String string2) {
        return string1 != null && string2 != null;
    }

}
