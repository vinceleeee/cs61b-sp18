package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int[] secretEdgeTo;
    private Maze maze;
    private Stack<Integer> stack = new Stack<>();
    int parent = Integer.MAX_VALUE;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        stack.push(0);
        distTo[0] = 0;
        secretEdgeTo = new int[maze.V()];
        secretEdgeTo[0] = 0;
    }

    @Override
    public void solve() {
        checkCycle();
    }

    private void checkCycle() {
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            marked[temp] = true;
            announce();
            for (int i : maze.adj(temp)) {
                if (i == secretEdgeTo[temp]) {
                    continue;
                }
                if (!marked[i]) {
                    stack.push(i);
                    distTo[i] = distTo[temp] + 1;
                    secretEdgeTo[i] = temp;
                    parent = temp;
                } else {
                    edgeTo[i] = temp;
                    while (temp != i) {
                        edgeTo[temp] = secretEdgeTo[temp];
                        temp = secretEdgeTo[temp];
                    }
                    announce();
                    return;
                }
            }
        }
    }
}

