import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlikTest {

    @Test
    void isSameNumber() {
        int i = 129;
        int j = 129;
        assertTrue(Flik.isSameNumber(i, j));
    }
}