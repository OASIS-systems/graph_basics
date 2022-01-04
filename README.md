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
1. Set all to half of Integer.MAX_VALUE (Infinity). After that, update startVertex distance (distance = 0)
2. Add startVertex to TreeSet<Vertex>
3. While TreeSet<Vertex> is not empty:
    - pollFirst from TreeSet<Vertex>
    - For each vertex near, try to do relaxation (if it happend, add vertex to the TreeSet<Vertex>)
4. Your result will be nearest distance from startVertex to each in graph
         
#### How to reproduce path?
1. At each performed relaxation add pointer (pointer at first is startVertex, then pointer is pollFirst from TreeSet<Vertex>) to paths array (for key use <s>relaxed</s> vertex)
2. Than using stack (because you need to reverse path), print it out. Exemple for viewing all pathes from startVertex:
  
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
