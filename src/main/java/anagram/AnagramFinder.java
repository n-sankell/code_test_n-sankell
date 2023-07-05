package anagram;

import java.util.Arrays;

public class AnagramFinder {

    public static boolean isAnagram(String string1, String string2) {
        return sortString(string1).equals(sortString(string2));
    }

    private static String sortString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

}
