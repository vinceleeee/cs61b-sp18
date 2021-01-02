package lab11.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Queue<Integer> queue = new ArrayDeque<>();

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        queue.add(s);
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            marked[temp] = true;
            announce();
            if (temp == t) {
                targetFound = true;
            }
            if (targetFound) {
                return;
            }

            for (int i: maze.adj(temp)) {
                if (!marked[i]) {
                    queue.add(i);
                    edgeTo[i] = temp;
                    distTo[i] = distTo[temp] + 1;
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs();
    }
}

