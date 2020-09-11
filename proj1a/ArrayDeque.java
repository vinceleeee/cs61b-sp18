public class ArrayDeque<T> {

    private int size;
    private int nextFirst = 0;
    private int nextLast = 0;
    private T[] a;

    private int minusOne(int index) {
        if (index == 0) {
            return size - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        if (index == size -1) {
            return 0;
        } else {
            return index + 1;
        }
    }


    public ArrayDeque() {
        a = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        a[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        a[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i=plusOne(nextFirst); i<=minusOne(nextLast); i++) {
            System.out.print(a[i] + " ");
        }
    }

    public T removeFirst() {
        int index = plusOne(nextFirst);
        size -= 1;
        T temp = a[index];
        a[index] = null;
        return temp;
    }

    public T removeLast() {
        int index = minusOne(nextLast);
        size -= 1;
        T temp = a[index];
        a[index] = null;
        return temp;
    }

    public T get(int index) {
        return a[index];
    }
}
