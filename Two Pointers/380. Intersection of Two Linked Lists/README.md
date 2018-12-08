# Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

Example:  
The following two linked lists:
```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3 → null
                   ↗            
B:     b1 → b2 → b3
```
begin to intersect at node c1.

_Challenge_:  
Your code should preferably run in `O(n)` time and use only `O(1)` memory.

_Notice_:  
If the two linked lists have no intersection at all, return `null`.   
The linked lists must retain their **original structure** after the function returns.  
You may assume there are **no cycles** anywhere in the entire linked structure.  
---
The first method is O(n) time and O(n) space using a HashSet. Easier to think and understand.

The second method is a mathematics approach.

Mark the unique part (with the intersected part) of list A as `a`, and unique part of list B as `b` and the intersected part as `c`.  
Let two pointers `pa` and `pb` start at `headA` and `headB`.  
When `pa` hit the end of list A (`pa.next == null`), it goes back to `headB` (`pa == headB`).  
Same for `pb`.  
The intersection node must be at when `pa` and `pb` travel `(a + b + c + 1)` nodes.  
Use a `integer` to record the times of two pointers hitting the end of a list. If it hits more than two times, then it means that there are no intersection between two linked lists.  

In this test case:  
`a = 2`, `b = 3`, `c = 3`. Intersection is at `2 + 3 + 3 + 1 = 9`