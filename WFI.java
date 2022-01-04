package algo.graph;

/**
 *      WFI (also known as Floyd's algorithm,
 *      the Roy–Warshall algorithm, the Roy–Floyd algorithm)
 *
 *      Warshall Floyd Ingerman
 *      (Warshall, Floyd, Roy - idea; Peter Ingerman - algorithm)
 *
 *      Performance: O(V³) Θ(V²)
 *          where V - count of Vertices
 *
 *      Additional info. Graph belllow accept weight no more
 *      than Integer.MAX_VALUE-1`000`000`000, because
 *      when java add to Integer.MAX_VALUE at least 1,
 *      result is Integer.MIN_VALUE
 *
 *      @author OASIS systems
 */

public class WFI {
    public static void main(String[] args) {
        /*  INPUT VIEW
                  (0)
               ⁵/ ¹| ³\
              (1) (4) (2)
               ¹\⁶/
                (3)
         */
        // Directed Graph implementation
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 4, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 4, 6);

        graph.WFI();
        graph.show();

        System.out.println("========================================");

        // Undirected Graph implementation
        Graph graph2 = new Graph(5);
        graph2.addEdgeUndirected(0, 1, 5);
        graph2.addEdgeUndirected(0, 4, 1);
        graph2.addEdgeUndirected(0, 2, 3);
        graph2.addEdgeUndirected(1, 3, 1);
        graph2.addEdgeUndirected(3, 4, 6);

        graph2.WFI();
        graph2.show();

        System.out.println("========================================");

        // Undirected Graph with Paths reconstruction
        // implementation (the same for directed graph)
        Graph graph3 = new Graph(5, true);
        graph3.addEdgeUndirected(0, 1, 5);
        graph3.addEdgeUndirected(0, 4, 1);
        graph3.addEdgeUndirected(0, 2, 3);
        graph3.addEdgeUndirected(1, 3, 1);
        graph3.addEdgeUndirected(3, 4, 6);

        graph3.WFIwthPaths();
        graph3.shortestPath(0, 3);
        graph3.shortestPath(0, 1);
        graph3.shortestPath(3, 2);
        graph3.shortestPath(3, 3);
        graph3.shortestPath(6, 5);
    }

    private static class Graph {
        private final int INF = 1000000000;
        private int[][] matrix, next;
        private int n;
        private boolean includePaths = false;
        public Graph(int size) {
            matrix = new int[size][size];
            this.n = size;

            for(int t = 0; t < n; t++)
                for (int b = 0; b < n; b++)
                    matrix[t][b] = ( t==b ? 0 : INF );
        }

        public Graph(int size, boolean includePaths) {
            matrix = new int[size][size];
            next = new int[size][size];
            this.n = size;
            this.includePaths = includePaths;

            for(int t = 0; t < n; t++)
                for (int b = 0; b < n; b++) {
                    next[t][b] = (t == b ? 0 : Integer.MIN_VALUE);
                    matrix[t][b] = (t == b ? 0 : INF);
                }
        }

        public void addEdge(int from, int to, int weight) {
            matrix[from][to] = weight;
            if(includePaths) next[from][to] = to;
        }
        public void addEdgeUndirected(int from, int to, int weight) {
            matrix[from][to] = weight;
            matrix[to][from] = weight;
            if(includePaths) {
                next[from][to] = to;
                next[to][from] = from;
            }
        }

        public void WFI(){
            for(int k = 0; k < n; k++)
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++)
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
        }

        public void WFIwthPaths(){
            for(int k = 0; k < n; k++)
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++) {
                        if(isMin(matrix[i][j], matrix[i][k] + matrix[k][j])){
                            matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                            next[i][j] = next[i][k];
                        }
                    }
        }

        private boolean isMin(int a, int b){
            if(a>b) return true;
            else return false;
        }

        public void show(){
            for(int x=0; x < n; x++) {
                for (int y = 0; y < n; y++)
                    System.out.print((matrix[x][y]==INF ? "-" : matrix[x][y])+" ");
                System.out.println();
            }
        }

        public void shortestPath(int from, int to) {
            if(next.length <= from || next[from].length <= to || next[from][to] == Integer.MIN_VALUE) {
                System.out.print("Path from " + from + " to " + to + " does not exist");
                return;
            }

            System.out.print("The shortest path from "+from+" to "+to+": "+from);
            while(from != to){
                from = next[from][to];
                System.out.print(">" + from);
            }
            System.out.println();
        }
    }
}
