# Window Sum

Given an array of n integers, and a moving window(size `k`), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

Example

For array `[1,2,7,8,5]`, moving window size `k` = 3.

1 + 2 + 7 = 10

2 + 7 + 8 = 17

7 + 8 + 5 = 20

return `[10,17,20]`

---
Don't simple add the numbers in the window all together. Try to find the relationship between each window in the result array.