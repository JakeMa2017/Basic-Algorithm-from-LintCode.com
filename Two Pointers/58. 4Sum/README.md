# 4Sum
Given an array `nums` of `n` integers, are there elements a, b, c, and d in nu s such that a + b + c + d = `target`?

Find all unique quadruplets in the array which gives the sum of target.

Example  
Given array `nums = {1, 0, -1, 0, -2, 2}`, and `target = 0`. A solution set is:
```
(-1, 0, 0, 1)
(-2, -1, 1, 2)
(-2, 0, 0, 2)
```
Notice  
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)  
The solution set **must not** contain duplicate quadruplets.

---

Note that for those removing duplicates codes, duplicate results will be added to `results` list if they are not added.  
Also, if not start with next number (`i != 0` and `j != i + 1`) in the two for loops, some correct result will be skipped, which leads to wrong answers.