# Graph Basics
Includes BFS, DFS, Dijkstra, WFI, Bellman Ford

## BFS (Breadth-first search)
<p>BFS describes a strategy for searching a graph, but it does not say that you must search for anything in particular. Works on a Queue (FIFO) basis</p>

<p>
Performance: O(E + V), <br>
&emsp;&emsp;where V - vertices <br>
&emsp;&emsp;and E - edges
</p>


         (0)
       /  |  \
     (1) (2) (3)
      |
     (4)
     Output BFS: 0 1 2 3 4


<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/4/46/Animated_BFS.gif" style="width: 300px;" /><br>
    <a href="http://creativecommons.org/licenses/by-sa/3.0/">CC BY-SA 3.0</a>, via Wikimedia Commons</span>
</p>


## DFS (Deadth-first search)
<p>Similar to BFS but works on a Stack (LIFO) basis</p>

<p>
Performance: O(E + V), <br>
&emsp;&emsp;where V - vertices <br>
&emsp;&emsp;and E - edges
</p>

         (0)
       /  |  \
     (1) (2) (3)
      |
     (4)
     Output DFS: 0 1 4 2 3

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif" style="width: 300px;" /><br>
    <a href="http://creativecommons.org/licenses/by-sa/3.0/">CC BY-SA 3.0</a>, via Wikimedia Commons</span>
</p>


## Dijkstra
<p>Dijkstra's algorithm adapts BFS to let you find single-source shortest paths. Doesn't work with negative weight</p>

#### How it works?
1. Set all Vertex distance to Integer.MAX_VALUE (Infinity). After that, update startVertex distance (distance = 0)
2. Add startVertex to TreeSet<Vertex>
3. While TreeSet<Vertex> is not empty:
    - pollFirst from TreeSet<Vertex>
    - For each vertex near, try to do relaxation (if it happend, add vertex to the TreeSet<Vertex>)
4. Your result will be nearest distance from startVertex to each in graph
         
#### How to reproduce path?
1. At each performed relaxation add pointer (pointer at first is startVertex, then pointer is pollFirst from TreeSet<Vertex>) to paths array (for key use <s>relaxed</s> vertex)
2. Than using stack (because you need to reverse path), print it out. Exemple for viewing all pathes from startVertex:
         

  
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

  
<p>
Performance: O(E + VlogV) Θ(ElogV), <br>
&emsp;&emsp;where V - vertices <br>
&emsp;&emsp;and E - edges
</p>

         (0)
      ⁵/ ¹| ³\
     (1) (4) (2)
      ¹\⁶/
       (3)
     Output: 0 5 3 6 1
     
     Path from 0 to 3: 0->1->3
     Path from 0 to 4: 0->4
     No way for 5

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif" style="width: 300px;" /><br>
    <a href="http://creativecommons.org/licenses/by-sa/3.0/">CC BY-SA 3.0</a>, via Wikimedia Commons</span>
</p>

## WFI
<p>Also known as Floyd's algorithm, the Roy–Warshall algorithm, the Roy–Floyd algorithm.<br>
&emsp;&emsp;WFI means<br>
&emsp;&emsp;Warshall Floyd Ingerman<br>
&emsp;&emsp;(Warshall, Floyd, Roy - idea; Peter Ingerman - algorithm) </p>
         
#### How it works?
1. Create adjacency matrix with weight as values. Set diagonal of 0-s (vertex can not be connected to itself). For no connection use `∞` Example:
         
           A B C
         A 0 2 3
         B ∞ 0 1
         C ∞ ∞ 0
         
2. Use the formula bellow to get result:
         
         matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
         
3. Write some code:
         
             for(int k = 0; k < n; k++)
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++)
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
         
         
#### How to reproduce path?
1. At each performed relaxation add pointer (pointer at first is startVertex, then pointer is pollFirst from TreeSet<Vertex>) to paths array (for key use <s>relaxed</s> vertex)
2. Than using stack (because you need to reverse path), print it out. Exemple for viewing all pathes from startVertex:

<p>
Performance: O(V³) Θ(V²), <br>
&emsp;&emsp;where V - count of Vertices
</p>

<p align="center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/b/b2/Floyd-Warshall-Algorithm-Problem.png" style="width: 800px;" /><br>
    <a href="http://creativecommons.org/licenses/by-sa/3.0/">CC BY-SA 3.0</a>, via Wikimedia Commons</span>
</p>
