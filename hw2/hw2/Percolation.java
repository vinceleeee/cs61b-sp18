package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] siteArray;
    private WeightedQuickUnionUF qu;
    private WeightedQuickUnionUF qu2;
    private int size;
    private int count;

    private final int top;
    private final int bottom;
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        } else {
            size = N;
            count = 0;
            siteArray = new boolean[N][N];
            qu = new WeightedQuickUnionUF(size * size + 2);
            qu2 = new WeightedQuickUnionUF(size * size + 2);
            top = size * size;
            bottom = size * size + 1;
        }
    } // create N-by-N grid, with all sites initially blocked

    private int xyTo1D(int r, int c) {
        return r * size + c;
    }

    public void open(int row, int col) {
        if (row >= size || col >= size || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        } else if (siteArray[row][col]) {
            return;
        } else {
            siteArray[row][col] = true;
            count += 1;
            if (row == 0) {
                qu.union(top, xyTo1D(row, col));
                qu2.union(top, xyTo1D(row, col));
            }
            if (row > 0 && siteArray[row - 1][col]) {
                qu.union(xyTo1D(row, col), xyTo1D(row - 1, col));
                qu2.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            }
            if (row < size - 1 && siteArray[row + 1][col]) {
                qu.union(xyTo1D(row, col), xyTo1D(row + 1, col));
                qu2.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            }
            if (col > 0 && siteArray[row][col - 1]) {
                qu.union(xyTo1D(row, col), xyTo1D(row, col - 1));
                qu2.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            }
            if (col < size - 1 && siteArray[row][col + 1]) {
                qu.union(xyTo1D(row, col), xyTo1D(row, col + 1));
                qu2.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            }
            if (row == size - 1) {
                if (qu.connected(xyTo1D(row, col), top)) {
                    qu.union(xyTo1D(row, col), bottom);
                }
                qu2.union(xyTo1D(row, col), bottom);
            }
        }
    }      // open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (row >= size || col >= size || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return siteArray[row][col];
        }
    } // is the site (row, col) open?
    public boolean isFull(int row, int col) {
        if (row >= size || col >= size || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return qu.connected(xyTo1D(row, col), top);
        }
    } // is the site (row, col) full?
    public int numberOfOpenSites() {
        return count;
    }          // number of open sites
    public boolean percolates() {
        return qu2.connected(top, bottom);
    }           // does the system percolate?

    public static void main(String[] args) {

    }  // use for unit testing (not required)
}
