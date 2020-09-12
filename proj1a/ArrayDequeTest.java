class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void test1() {
        ArrayDeque<Integer> a = new ArrayDeque();
        boolean passed = checkEmpty(true, a.isEmpty());

        a.addFirst(0);
        passed = passed && checkSize(a.size(),1);
        a.addFirst(1);
        passed = passed && checkSize(a.size(),2);
        a.addFirst(2);
        passed = passed && checkSize(a.size(),3);
        a.addFirst(3);
        passed = passed && checkSize(a.size(),4);
        System.out.print(a.get(0) + " " + a.get(1) + " " + a.get(2) + " " + a.get(3) + " " + a.get(4) + " " +
                a.get(5) + " " + a.get(6) + " " + a.get(7));
        a.addFirst(3);
        a.addFirst(3);
        a.addFirst(3);
        a.addFirst(3);
        a.addFirst(3);
        a.addFirst(3);
        a.addFirst(3);
        a.addFirst(3);
        System.out.print(a.get(0) + " " + a.get(1) + " " + a.get(2) + " " + a.get(3) + " " + a.get(4) + " " +
                a.get(5) + " " + a.get(6) + " " + a.get(7)+ " " + a.get(8)+ " " + a.get(9)+ " " + a.get(10));

    }


    public static void main(String args[]) {
        test1();
    }
}