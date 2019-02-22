# Topological Sorting

Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge `A -> B` in graph, `A` must before `B` in the order list.  
The first node in the order can be any node in the graph with no nodes direct to it.  
Find any topological order for the given graph.  

Example  
For graph as follow:  

The topological order can be:

```
[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
```

Challenge  
Can you do it in both BFS and DFS?

Notice
You can assume that there is at least one topological order in the graph.

---
Notes:  
Typical directed graph. Use a hash map to construct the grpah. Node name as key and number of neighbors as value.  
Add node without 