import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalidrome1() {
        assertFalse(palindrome.isPalindrome("fal"));
    }

    @Test
    public void testIsPalidrome2() {
        assertTrue(palindrome.isPalindrome("falaf"));
    }

    @Test
    public void testIsPalidrome3() {
        assertFalse(palindrome.isPalindrome("Ada"));
    }

    @Test
    public void testIsPalidrome4() {
        assertFalse(palindrome.isPalindrome(null));
    }
}
