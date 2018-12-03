# Josephus Problem

Given integer `n` and `m`, where n is the number of people and m is the number these people will count to. Counting starts from the first person. Whoever count to m is removed from the circle, and counting starts at `m + 1`. Find out the number of the last person remaining in the circle.

Example

`5 3`

Return

`4`

---
The detailed problem description can be found [here](https://en.wikipedia.org/wiki/Josephus_problem). Can be solved either use Linked List, which we need to simulate the whole process, or can be sovled by a math trick.

Let's say we have `n` and `m`. Label them as `0 ~ n - 1`, then the first one to be removed is at `(m - 1) % n`.

Mark this person as `k`, where `k = (m - 1) % n`. Therefore, this circle becomes `0, 1, 2, 3,..., k-2, k-1, k+1, k+2,..., n-2, n-1`.

Then we write it is this format (counting order, not actual label):
```
k + 1 -> 0
k + 2 -> 1
k + 3 -> 2
...
...
...
k - 2 -> n - 3
k - 1 -> n - 2
```

Now we have a `n-1, m` problem. Also, we can see that the equation to change the label `x` to counting order is `p(x) = (x - k - 1) % n`, so the reverse function of it would be `p^-1(x) = (x + k + 1) % n`. If we get the answer of `n-1, m`, then we can get the answer of `n, m`. To get the answer of `n-1, m`, we need to find the answer of `n-2, m`. Therefore,

`f(n, m) = q(n - 1, m) = p^-1(n - 1, m) = [f(n - 1, m) + k + 1] % n = [f(n - 1, m) + m] % n`

where `q(n - 1, m)` means the final result of `k+1, k+2,...,n-1, 0, 1,..., k-1` (just a representation to help understand this deduction) and `k = (m - 1) % n`.
