public class OffByN implements CharacterComparator {

    private int offset;

    public OffByN(int N) {
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == offset || x - y == -offset) {
            return true;
        } else {
            return false;
        }
    }
}
