#Heapify
---
Given an integer array, heapify it into a min-heap array.

Given `[3,2,1,4,5]`, return `[1,2,3,4,5]` or any legal heap array.


Convert an unordered integer array into a heap array. If it is min-heap, for each element `A[i]`, we will get `A[i * 2 + 1] >= A[i]` and `A[i * 2 + 2] >= A[i]`.

---

Can have O(n) and O(nlogn).