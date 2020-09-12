public class ArrayDeque<T> {

    private int size;
    private int nextFirst = 0;
    private int nextLast = 1;
    private int capacity = 8;
    private T[] a;

    private int minusOne(int index) {
        if (index == 0) {
            return capacity - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        if (index == capacity - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }


    public ArrayDeque() {
        a = (T[]) new Object[capacity];
        size = 0;
    }

    public void addFirst(T item) {
        if (nextFirst == nextLast) {
            resize(capacity * 2);
        }
        a[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    public void addLast(T item) {
        if (nextFirst == nextLast) {
            resize(capacity * 2);
        }
        a[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int newcap) {
        T[] newa = (T[]) new Object[newcap];
        int first = plusOne(nextFirst);
        int last = minusOne(nextLast);
        if (first > last) {
            System.arraycopy(a, first, newa, 0, capacity - first);
            System.arraycopy(a, 0, newa, capacity - first, last + 1);
        } else {
            System.arraycopy(a, first, newa, 0, last - first + 1);
        }
        capacity = newcap;
        nextFirst = capacity - 1;
        nextLast = size;
        a = newa;
    }

    public void printDeque() {
        for (int i = plusOne(nextFirst); i <= minusOne(nextLast); i++) {
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
        int realIndex = nextFirst;
        for (int i = 0; i <= index; i++) {
            realIndex = plusOne(realIndex);
        }
        return a[realIndex];
    }
}
