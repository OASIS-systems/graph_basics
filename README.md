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
