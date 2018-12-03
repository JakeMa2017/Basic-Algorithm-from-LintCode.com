# 3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

Example

For example, given array S = `[-1, 2, 1, -4]`, and target = `1`. The sum that is closest to the target is `2` (-1 + 2 + 1 = 2).

Challenge

`O(n^2)` time, `O(1)` extra space

Notice
You may assume that each input would have exactly one solution.

---

Similar Trick as in triangle count. It's just after couple moving-window problems, sometimes I forgot to use the most basic two pointers approach: `left = 0, right = nums.length - 1`. Then, move left and right accordingly.