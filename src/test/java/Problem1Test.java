import org.junit.Test;

import static anagram.AnagramFinder.isAnagram;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem1Test {

    @Test
    public void problem1TrueNoCase() {
        String a = "a-a-a-b-b-b-c-c-c";
        String b = "a-b-c-a-b-c-a-b-c";
        assertTrue(isAnagram(a, b));
    }

    @Test
    public void problem1TrueWithCase() {
        String a = "grÖnsAksBulJong";
        String b = "GöraNssKuLjOnbG";
        assertTrue(isAnagram(a, b));
    }

    @Test
    public void problem1FalseNoCase() {
        String a = "a-a-a-b-b-b-c-c-c";
        String b = "d-e-f-d-e-f-d-e-f";
        assertFalse(isAnagram(a, b));
    }

    @Test
    public void problem1FalseWithCase() {
        String a = "grÖnsXksBulJong";
        String b = "GöraNssKuLjXnbG";
        assertFalse(isAnagram(a, b));
    }

    @Test
    public void problem1FalseWrongLength() {
        String a = "a-a-a-b-b-b-c-c-c-c";
        String b = "a-b-c-a-b-c-a-b-c";
        assertFalse(isAnagram(a, b));
    }

    @Test
    public void problem1Trim() {
        String a = "  daab   ";
        String b = "   bada          ";
        assertTrue(isAnagram(a, b));
    }

    @Test
    public void problem1TrimEmptyString() {
        String a = " \n    ";
        String b = "   \t          ";
        assertFalse(isAnagram(a, b));
    }

    @Test
    public void problem1TrimEmptyString2() {
        String a = " ";
        String b = " ";
        assertFalse(isAnagram(a, b));
    }

    @Test
    public void problem1Null() {
        String b = " a";
        assertFalse(isAnagram(null, b));
    }

    @Test
    public void problem1Null2() {
        assertFalse(isAnagram(null, null));
    }

}
