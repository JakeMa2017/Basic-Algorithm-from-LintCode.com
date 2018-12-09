/**
 * Intersection of Two Linked List
 * Two Pointers
 * Jake Ma
 * 12-08-2018
 */

import java.util.HashSet;

public class IntersectionOfTwoLinkedList {

    public ListNode checkIntersect1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }

        HashSet<ListNode> set = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        set.add(headA);
        set.add(headB);
        while (a.next != null && b.next != null) {
            if (set.contains(a.next)) {
                return a.next;
            } else if (set.contains(b.next)) {
                return b.next;
            }

            set.add(a.next);
            set.add(b.next);
            a = a.next;
            b = b.next;
        }

        while (a.next != null) {
            if (set.contains(a.next)) {
                return a.next;
            }
            set.add(a.next);
            a = a.next;
        }
        while (b.next != null) {
            if (set.contains(b.next)) {
                return b.next;
            }
            set.add(b.next);
            b = b.next;
        }

        return null;
    }

    /**
     * Simpler approach.
     * Mark the size of list1 (w/o intersected part) as sizeA, 
     * list2(w/o intersected part) as sizeB, listInterceted as sizeC.
     * Let a pointer start at either headA or headB (go to another when hit the end).
     * It must point to the intersection after (sizeA + sizeB + sizeC + 1) steps.
     */
    public ListNode checkIntersect2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }

        ListNode a = headA;
        ListNode b = headB;

        int hitTheEnd = 0;
        while (a != b) {
            if (a.next != null) {
                a = a.next;
            } else {
                a = headB;
                hitTheEnd++;
            }
            if (b.next != null) {
                b = b.next;
            } else {
                b = headA;
                hitTheEnd++;
            }
            if (hitTheEnd > 2) {
                return null;
            }
        }

        return a;
    }
}
