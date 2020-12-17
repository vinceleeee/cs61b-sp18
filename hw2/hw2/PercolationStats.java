package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    double[] thresholds;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        } else {
            thresholds = new double[T];
            for (int i = 0; i < T; i++) {
                Percolation test = pf.make(N);
                while (!test.percolates()) {
                    test.open(StdRandom.uniform(0, N), StdRandom.uniform(0, N));
                }
                thresholds[i] = test.numberOfOpenSites() * 1.0 / (N * N);
            }
        }


    }// perform T independent experiments on an N-by-N grid
    public double mean() {
        return StdStats.mean(thresholds);
    }                                            // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }                                         // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return (mean() - 1.96 * stddev() / Math.sqrt(thresholds.length));
    }                                 // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return (mean() + 1.96 * stddev() / Math.sqrt(thresholds.length));
    }                                // high endpoint of 95% confidence interval

}
