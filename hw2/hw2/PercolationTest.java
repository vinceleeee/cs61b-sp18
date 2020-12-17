package hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {

    Percolation test = new Percolation(5);

    @Test
    void test1() {
        test.open(2, 4);
        assertTrue(test.isOpen(2, 4));
    }

    @Test
    void test2() {
        test.open(3, 4);
        assertTrue(test.isOpen(3, 4));
    }

    @Test
    void test3() {
        test.open(2, 4);
        test.open(3, 4);
        assertEquals(2, test.numberOfOpenSites());
    }

    @Test
    void test4() {
        test.open(2, 4);
        assertFalse(test.isFull(2, 4));
    }

    @Test
    void test5() {
        test.open(0, 4);
        assertTrue(test.isFull(0, 4));
    }

    @Test
    void test6() {
        test.open(0, 4);
        test.open(1, 4);
        assertTrue(test.isFull(1, 4));
    }

    @Test
    void test7() {
        test.open(0, 4);
        test.open(1, 4);
        assertFalse(test.isFull(2, 4));
    }

    @Test
    void test8() {
        test.open(0, 4);
        test.open(1, 4);
        test.open(1, 3);
        test.open(2, 3);
        test.open(2, 2);
        test.open(3, 2);
        assertTrue(test.isFull(3, 2));
    }

    @Test
    void test9() {
        test.open(0, 4);
        test.open(1, 4);
        test.open(2, 4);
        test.open(3, 4);
        test.open(4, 4);
        test.open(4, 1);
        assertFalse(test.isFull(4, 1));
    }

    @Test
    void test10() {
        test.open(0, 4);
        test.open(1, 4);
        test.open(2, 4);
        test.open(3, 4);
        test.open(4, 4);
        test.open(4, 1);
        assertTrue(test.percolates());
    }

    @Test
    void test11() {
        test.open(0, 4);
        test.open(1, 4);
        test.open(1, 3);
        test.open(2, 3);
        test.open(2, 2);
        test.open(3, 2);
        assertFalse(test.percolates());
    }

    @Test
    void test12() {
        test.open(0, 4);
        test.open(1, 4);
        test.open(2, 4);
        test.open(3, 4);
        test.open(4, 4);
        test.open(4, 2);
        assertFalse(test.isFull(4, 2));
    }

    @Test
    void test13() {
        test.open(0, 4);
        test.open(1, 4);
        test.open(2, 4);
        test.open(3, 4);
        test.open(4, 4);
        test.open(4, 2);
        test.open(3, 2);
        test.open(3, 3);
        assertTrue(test.isFull(4, 2));
    }
}
