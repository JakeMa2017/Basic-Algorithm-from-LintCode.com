# Partition Array II
Partition an unsorted integer array into three parts:

The front part < low

The middle part >= low & <= high

The tail part > high

Return any of the possible solutions.

Example
Given `[4,3,4,1,2,3,1,2]`, and low = `2` and high = `3`.

Change to `[1,1,2,3,2,3,4,4]`.

(`[1,1,2,2,3,3,4,4]` is also a correct answer, but `[1,2,1,2,3,3,4,4]` is not)

Challenge

1. Do it in place.
   
2. Do it in one pass (one loop).

Notice

low <= high in all testcases.