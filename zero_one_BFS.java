package algo.graph;

import java.util.*;

/**
 *  0-1 BFS
 *  Kind of BFS
 *
 *  Performance: O(E + V),
 *      where V - vertices
 *      and E - edges
 *
 *  @author OASIS systems
 */

public class zero_one_BFS {
    public static void main(String[] args) {
        /*  INPUT VIEW
                  (0)
               ⁰/ ¹| ⁰\
              (1) (4) (2)
               ¹\⁰/
                (3)
         */
        // Directed Graph implementation
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 0);
        graph.addEdge(0, 4, 1);
        graph.addEdge(0, 2, 0);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 4, 0);

        graph.zeroOneBFS(0);
        graph.show();
    }

    private static class Graph {
        private int n=0; // count of vertices
        private ArrayList<Integer> edges[];
        private int[][] edge_weight;
        private int[] dist;
        private final int INF = 1000000000;
        public Graph(int size){
            n = size;
            edges = new ArrayList[n];
            edge_weight = new int[n][n];
            dist = new int[n];
            for(int i=0; i<size; i++) {
                edges[i] = new ArrayList();
                dist[i] = INF;
            }
        }

        public void addEdge(int from, int to, int weight) {
            edges[from].add(to);
            edge_weight[from][to] = weight;
        }

        public void zeroOneBFS(int startPoint) {
            dist[startPoint] = 0;
            Deque<Integer> deque = new LinkedList<>();
            deque.addLast(startPoint);
            int pointer;
            while(!deque.isEmpty()){
                pointer = deque.removeFirst();
                for(int edge : edges[pointer]){
                    if(dist[pointer]+edge_weight[pointer][edge] < dist[edge]){
                        dist[edge] = dist[pointer]+edge_weight[pointer][edge];
                        if(edge_weight[pointer][edge] == 0) deque.addFirst(edge);
                        else  deque.addLast(edge);
                    }
                }
            }
        }

        public void show(){
            for(int i : dist)
                System.out.print(i+" ");
        }

    }
}