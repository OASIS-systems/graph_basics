package algo.graph;

/**
 *      Bellman Ford
 *      Work with negative cycles
 *      Doesn't work with undirected and at the
 *      same time negative edge
 *
 *      Performance: O(VE) Θ(VE),
 *          where V - vertices
 *          and E - edges
 *
 *      @author OASIS systems
 */

public class Bellman_Ford {
    public static void main(String[] args) {
        /*  INPUT VIEW
                  (0)
              ⁻⁵/ ⁻¹| ³\
              (1) (4) (2)
               ¹\⁶/
                (3)
         */
        Graph graph = new Graph(5, 5);
        graph.addEdge(0, 1, -5);
        graph.addEdge(0, 4, -1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 4, 6);

        System.out.println("Before: ");
        graph.checkNegWeightCycle();

        graph.BellmanFord(0);

        System.out.println("After: ");
        graph.checkNegWeightCycle();

        graph.show();

        System.out.println("======================");
        /*  INPUT VIEW
                  (1)
               ²/  | ²\
             (0) ⁻⁴/   (3)
               ⁵\ |
                 (2)
         */
        Graph graph2 = new Graph(4, 5);
        graph2.addEdge(0, 1, 2);
        graph2.addEdge(1, 0, 2);
        graph2.addEdge(0, 2, 5);
        graph2.addEdge(2, 1, -4);
        graph2.addEdge(1, 3, 2);

        System.out.println("After: ");
        graph2.BellmanFord(0);
        graph.checkNegWeightCycle();
        graph2.show();
    }

    private static class Graph {
        private int V, E=0; // count of vertices and edges
        private Edge edges[];
        private int[] dist;
        private final int INF = Integer.MAX_VALUE;
        public Graph(int sizeV, int sizeE){
            V = sizeV;
            edges = new Edge[sizeE];
            dist = new int[V];
        }

        public void addEdge(int from, int to, int weight) {
            edges[E] = (new Edge(from, to, weight));
            E++;
        }

        public void BellmanFord(int startPoint) {
            for(int i=0; i<V; i++)
                dist[i] = INF;
            dist[startPoint] = 0;

            for (int i = 1; i < V; ++i) {
                for (int j = 0; j < E; ++j) {
                    int u = edges[j].from;
                    int v = edges[j].to;
                    int weight = edges[j].weight;
                    if (dist[u] != INF && dist[u] + weight < dist[v])
                        dist[v] = dist[u] + weight;
                }
            }
        }

        public void checkNegWeightCycle(){
            for (int j = 0; j < E; ++j) {
                int u = edges[j].from;
                int v = edges[j].to;
                int weight = edges[j].weight;
                if (dist[u] != INF && dist[u] + weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
            System.out.println("Graph NOT contains negative weight cycle");
        }

        public void show(){
            for(int i : dist)
                System.out.print(i+" ");
            System.out.println();
        }

        private class Edge{
            int from, to, weight;
            public Edge(int from, int to, int weight){
                this.from = from;
                this.to = to;
                this.weight = weight;
            }
        }

    }
}
