#Symmetric Tree
---

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example
For example, this binary tree `{1,2,2,3,4,4,3}`is symmetric:
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following `{1,2,2,#,3,#,3}` is not:
```
    1
   / \
  2   2
   \   \
   3    3
```
---
Very interesting problem. It can either use recursive or iterative.

Iterative is pretty straightforward from BFS.

Recursive is rather neat.