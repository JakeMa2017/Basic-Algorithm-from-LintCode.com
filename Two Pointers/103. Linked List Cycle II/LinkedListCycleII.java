/**
 * Linked List Cycle II
 * Two Pointers
 * Jake Ma
 * 1-8-2018
 */


/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListCycleII {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        
        return head;
    }
}