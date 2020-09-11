public class LinkedListDeque<T> {

    public class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;
    private T ph;

    public LinkedListDeque () {
        sentinel = new StuffNode(null, ph, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        if (sentinel.prev == sentinel) {
            sentinel.prev = sentinel.next;
        }
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new StuffNode(sentinel.prev, item, sentinel);
        if (sentinel.next == sentinel) {
            sentinel.next = sentinel.prev;
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
        if (size == 0) return null;
        StuffNode temp = sentinel.next;
        sentinel.next = temp.next;
        temp.next.prev = sentinel;
        size -= 1;
        return temp.item;
    }

    public T removeLast() {
        if (size == 0) return null;
        StuffNode temp = sentinel.prev;
        sentinel.prev = temp.prev;
        temp.prev.next = sentinel;
        size -= 1;
        return temp.item;
    }

    public T get(int index) {
        StuffNode s = sentinel.next;
        if (index > size || size == 0) {
            return null;
        }
        while (index > 1) {
            s = s.next;
            index -= 1;
        }
        return s.item;
    }

    private T getRecursive(int index, StuffNode s) {
        if (index > size || size == 0) {
            return null;
        }
        if (index == 1) {
            return s.item;
        } else {
            return getRecursive(index - 1, s.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

}
