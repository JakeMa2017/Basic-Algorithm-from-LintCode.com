# Binary Tree Path Sum
---

Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the **leaf nodes**.

Example:

Given a binary tree, and target = 5:
```
     1
    / \
   2   4
  / \
 2   3
```

Return:
```
[
  [1, 2, 2],
  [1, 4]
]
```
---

Can use either [DFS](https://github.com/JakeMa2017/Basic-Algorithm/tree/master/Divide%20and%20Conquer/376.Binary%20Tree%20Path%20Sum) or Divide and Conquer to solve this problem.
See