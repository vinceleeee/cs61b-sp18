import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByFive = new OffByN(5);

    // Your tests go here.
    @Test
    public void testOBO1() {
        assertTrue(offByFive.equalChars('a','f'));
    }

    @Test
    public void testOBO2() {
        assertFalse(offByFive.equalChars('a','c'));
    }
}
