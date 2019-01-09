# Linked List Cycle II
Given a linked list, return the node where the cycle begins.

If there is no cycle, return `null`.

Example  
Given `-21->10->4->5`, tail connects to node index 1，return `10`

Explanation：  
The last node `5` points to the node whose index is 1, which is `10`, so the entrance of the ring is `10`

Challenge  
Follow up:

Can you solve it without using extra space?

---

Can be easily solved by a HashSet, but what if we don't use extra space?

Here we use fast and slow pointers. Note that:

1. If starts with `slow = head; fast = head.next`, then we should use `head == slow.next` to find the entrance.
2. If starts with `slow = head; fast = head`, then `head == slow` is fine.

Mathematical Proof:

1. Let `n` be the steps that `slow` had moved until they first met, thus `fast` had moved `2n` steps. 
2. Let `L` be the lenth of the ring.
3. Let `p` be the distance between `head` and entrance node, `c` be the distance between entrance node and the node where `slow` and `fast` first met.
4. Therefore, we have: `p + c = n` and `p + c + kL = 2n`, where `k = 1, 2, 3...`
5. From 3, we have `L = n`, which gives us `p = L - c`.
6. By the definition of `c`, `slow` will be at the entrance node after `L - c` steps, which equals to `p`.
7. By the definition of `p`, if `head` starts moving 1 step each time, it will meet `slow` at the entrance node after `p` steps.

