import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOBO1() {
        assertTrue(offByOne.equalChars('a', 'b'));
    }

    @Test
    public void testOBO2() {
        assertFalse(offByOne.equalChars('a', 'c'));
    }

    @Test
    public void testOBO3() {
        assertFalse(offByOne.equalChars('A', 'b'));
    }

    @Test
    public void testOBO4() {
        assertTrue(offByOne.equalChars('%', '&'));
    }
}
