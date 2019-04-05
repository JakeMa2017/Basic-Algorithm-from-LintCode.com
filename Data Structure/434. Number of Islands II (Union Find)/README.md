# Number of Islands II

Given a `n`,`m` which means the row and column of the 2D matrix and an array of pair `A`(size `k`). Originally, the 2D matrix is all `0` which means there is only sea in the matrix. The list pair has `k` operator and each operator has two integer `A[i].x`, `A[i].y` means that you can change the grid matrix`[A[i].x][A[i].y]` from sea to island. Return how many island are there in the matrix after each operator.

### Example 1

Input: `n = 4`, `m = 5`, `A = [[1,1],[0,1],[3,3],[3,4]]`  
Output: `[1,1,2,2]`  
Explanation:
```
1.  00000
    00000
    00000
    00000
2.  00000
    01000
    00000
    00000
3.  01000
    01000
    00000
    00000
4.  01000
    01000
    00000
    00010
5.  01000
    01000
    00000
    00011
```

### Example 2

Input: `n = 3`, `m = 3`, `A = [[0,0],[0,1],[2,2],[2,1]]`  
Output: `[1, 1, 2, 2]`  

### Notice
`0` is represented as the sea, `1` is represented as the island. If two `1` is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

### My Notes
Remember to take into account that in some cases there may be a decrease in the number of islands, so be sure to add a `if` clause to decrease `count`.

#### Example
Input: `n = 2`, `m = 2`, `A = [[[0,0],[1,1],[1,0],[0,1]]`  
Output: `[1, 2, 1, 1]`  

From this example we can see that in the thid input operator, the number of islands has decreased.