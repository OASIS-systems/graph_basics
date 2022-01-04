package algo.graph;

import java.util.*;

/**
 *  Dijkstra
 *  Dijkstra's algorithm adapts BFS to let you find
 *  single-source shortest paths
 *  Doesn't work with negative numbers
 *
 *  Performance: O(E VlogV),
 *      where V - vertices
 *      and E - eges
 *
 *  @author OASIS systems
 */

public class Dijkstra {
    public static void main(String[] args) {
        /*  INPUT VIEW
                  (0)
               ⁵/ ¹| ³\
              (1) (4) (2)
               ¹\⁶/
                (3)
         */
        Graph graph = new Graph(7);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 4, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 4, 6);

        /*
        0 1 5
        0 4 1
        0 2 3
        1 3 1
        3 4 6
         */

        System.out.println("Dijkstra from the first:");
//        graph.Dijkstra(0);
//         0 5 3 6 1

        graph.Dijkstra_pathes(0);
        /*
        Path from 0 to 0: 0
        Path from 0 to 1: 0->1
        Path from 0 to 2: 0->2
        Path from 0 to 3: 0->1->3
        Path from 0 to 4: 0->4
        No way for 5
        No way for 6
         */
    }

    private static class Graph {
        private int n=0; // count of vertices
        private LinkedList<Edge> edges[];
        private Vertex[] vertices;
        public Graph(int size){
            n = size;
            edges = new LinkedList[n];
            vertices = new Vertex[n];
            for(int i=0; i<size; i++) {
                edges[i] = new LinkedList<>();
                addVertex(i);
            }
        }

        public void addVertex(int id) { vertices[id] = new Vertex(id, Integer.MAX_VALUE); }
        public void addEdge(int from, int to, int mass) { edges[from].add(new Edge(vertices[from].id, vertices[to].id, mass)); }

        public void Dijkstra(int startPoint) {
            TreeSet<Vertex> list = new TreeSet<>();
            vertices[startPoint].dist = 0;
            list.add(vertices[startPoint]);
            Vertex pointer;
            while(!list.isEmpty()){
                pointer = list.pollFirst();
                for(Edge edge : edges[pointer.id]){
                    if(minDist(vertices[edge.to], edge, pointer)){
                        list.add(vertices[edge.to]);
                    }
                }
            }

            // Output
            for(Vertex vertex : vertices)
                System.out.print(vertex.dist+" ");
        }

        public void Dijkstra_pathes(int startPoint) {
            TreeSet<Vertex> list = new TreeSet<>();
            int[] paths = new int[this.n];
            vertices[startPoint].dist = 0;
            list.add(vertices[startPoint]);
            Vertex pointer;
            while(!list.isEmpty()){
                pointer = list.pollFirst();
                for(Edge edge : edges[pointer.id]){
                    if(minDist(vertices[edge.to], edge, pointer)){
                        paths[vertices[edge.to].id] = (pointer.id);
                        list.add(vertices[edge.to]);
                    }
                }
            }

            // Output
            Stack<Integer> realPath = new Stack<>();
            for(Vertex vertex : vertices) {
                if(vertex.dist != Integer.MAX_VALUE) {
                    System.out.print("Path from " + startPoint + " to " + vertex.id + ": " + startPoint);
                    for (int v = vertex.id; v != startPoint; v = paths[v])
                        realPath.push(v);
                    while (!realPath.isEmpty())
                        System.out.print("->" + realPath.pop());
                    System.out.println();
                }else System.out.println("No way for "+vertex.id);
            }
        }

        private boolean minDist(Vertex to, Edge edge, Vertex pointer) {
            if(edge.mass + pointer.dist < to.dist){
                vertices[edge.to].dist = edge.mass + pointer.dist;
                return true;
            }
            return false;
        }

        private class Vertex implements Comparable {
            public int dist, id;
            public Vertex(int id, int dist) {
                this.dist = dist;
                this.id = id;
            }

            @Override
            public int compareTo(Object o) {
                if(dist < ((Vertex)o).dist) return -1;
                else return 1;
            }
        }
        private class Edge {
            public int from, to;
            public int mass;
            public Edge(int from, int to, int mass){
                this.from = from;
                this.to = to;
                this.mass = mass;
            }
        }
    }
}