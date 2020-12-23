package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /*
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = oomages.size();
        boolean fewerThan = false;
        boolean moreThan = false;
        int[] m = new int[M];
        for (int i = 0; i < M; i++) {
            m[i] = 0;
        }
        for (Oomage oomage: oomages) {
            m[(oomage.hashCode() & 0x7FFFFFFF) % M] += 1;
        }
        for (int i = 0; i < M; i++) {
            if (m[i] < N / 50) {
                fewerThan = true;
            }
            if (m[i] > N / 2.5) {
                moreThan = true;
            }
        }
        return !fewerThan && !moreThan;
    }
}
