/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current1 = headA;
        ListNode current2 = headB;

        if (current1 == null || current2 == null) return null;

        while (current1 != current2) {
            current1 = (current1 != null) ? current1.next : headB;
            current2 = (current2 != null) ? current2.next : headA;
        }

        return current1;
    }
}
