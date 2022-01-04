package algo.graph;

/**
 *    BFS works on a Queue (FIFO) basis
 *        (0)
 *      /  |  \
 *    (1) (2) (3)
 *     |
 *    (4)
 *    Output BFS: 0 1 2 3 4
 *
 *    BFS describes a strategy for searching a graph,
 *    but it does not say that you must search for
 *    anything in particular
 *
 *    Performance: O(E + V),
 *      where V - vertices
 *      and E - edges
 *
 *    @author OASIS systems
 */

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(7, 6);
        graph.addEdge(8, 8);

        System.out.println("BFS from the first:");
        graph.BFS(0);
    }

    private static class Graph {
        private int n=0; // count of vertices
        private ArrayList<Integer> edges[];
        public Graph(int size){
            n = size;
            edges = new ArrayList[n];
            for(int i=0; i<size; i++)
                edges[i] = new ArrayList();
        }

        public void addEdge(int from, int to) {
            edges[from].add(to);
        }

        public void BFS(int startPoint) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            visited[startPoint] = true;
            queue.add(startPoint);
            while(!queue.isEmpty()){
                startPoint = queue.poll();
                System.out.print(startPoint+" ");
                for(int edge : edges[startPoint]){
                    if(!visited[edge]){
                        visited[edge] = true;
                        queue.add(edge);
                    }
                }
            }
        }

    }
}
