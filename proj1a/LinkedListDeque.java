public class LinkedListDeque<T> {

    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;
    private T ph;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, ph, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        if (sentinel.prev == sentinel) {
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next.next.prev = sentinel.next;
        }
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new StuffNode(sentinel.prev, item, sentinel.prev.next);
        if (sentinel.next == sentinel) {
            sentinel.next = sentinel.prev;
        } else {
            sentinel.prev.prev.next = sentinel.prev;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode s = sentinel.next;
        while (s != sentinel) {
            System.out.print(s.item + " ");
            s = s.next;
        }
        System.out.println(" ");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        StuffNode temp = sentinel.next;
        T tempItem = temp.item;
        sentinel.next = temp.next;
        temp.next.prev = temp.prev;
        size -= 1;
        return tempItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        StuffNode temp = sentinel.prev;
        T tempItem = temp.item;
        sentinel.prev = temp.prev;
        temp.prev.next = temp.next;
        size -= 1;
        return tempItem;
    }

    public T get(int index) {
        StuffNode s = sentinel.next;
        if (index > size - 1 || size == 0) {
            return null;
        }
        while (index > 0) {
            s = s.next;
            index -= 1;
        }
        return s.item;
    }

    private T getRecursive(int index, StuffNode s) {
        if (index > size - 1 || size == 0) {
            return null;
        }
        if (index == 0) {
            return s.item;
        } else {
            return getRecursive(index - 1, s.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

}
