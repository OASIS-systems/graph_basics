package algo.graph;

/**
 *    DFS works on a Stack (LIFO) basis
 *        (0)
 *      /  |  \
 *    (1) (2) (3)
 *     |
 *    (4)
 *    Output DFS: 0 1 4 2 3
 *
 *    Performance: O(E + V),
 *      where V - vertices
 *      and E - edges
 *
 *    @author OASIS systems
 */

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(2);

        // BFS 2 0 3 1
        // DFS 2 3 0 1
    }

    private static class Graph {
        private int n;
        private LinkedList<Integer> edges[];
        public Graph(int size) {
            this.n = size;
            this.edges = new LinkedList[this.n];
            for(int i = 0; i < n; i++)
                this.edges[i] = new LinkedList<Integer>();
        }

        public void addEdge(int from, int to) {
            this.edges[from].add(to);
        }

        public void DFS(int startPoint) {
            boolean[] visited = new boolean[n];
            Stack<Integer> queue = new Stack<>();
            queue.add(startPoint);
            while(!queue.isEmpty()){
                startPoint = queue.pop();
                if(!visited[startPoint]){
                    visited[startPoint] = true;
                    System.out.print(startPoint+" ");
                    for(int edge : edges[startPoint]){
                        queue.add(edge);
                    }
                }
            }
        }

    }
}