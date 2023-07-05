import anagram.AnagramFinder;
import org.junit.Test;

public class Problem1Test {

    @Test
    public void Problem1TrueNoCase() {
        String a = "a-a-a-b-b-b-c-c-c";
        String b = "a-b-c-a-b-c-a-b-c";
        assert AnagramFinder.isAnagram(a, b);
    }

    @Test
    public void Problem1TrueWithCase() {
        String a = "grÖnsAksBulJong";
        String b = "GöraNssKuLjOnbG";
        assert AnagramFinder.isAnagram(a, b);
    }

    @Test
    public void Problem1FalseNoCase() {
        String a = "a-a-a-b-b-b-c-c-c";
        String b = "d-e-f-d-e-f-d-e-f";
        assert !AnagramFinder.isAnagram(a, b);
    }

    @Test
    public void Problem1FalseWithCase() {
        String a = "grÖnsXksBulJong";
        String b = "GöraNssKuLjXnbG";
        assert !AnagramFinder.isAnagram(a, b);
    }

    @Test
    public void Problem1FalseWrongLength() {
        String a = "a-a-a-b-b-b-c-c-c-c";
        String b = "a-b-c-a-b-c-a-b-c";
        assert !AnagramFinder.isAnagram(a, b);
    }

}
