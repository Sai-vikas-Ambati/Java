/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode current = head;

        while (current != null) {
            ListNode index = head;

            while (index != current) {
                if (index.val > current.val) {
                    int temp = index.val;
                    index.val = current.val;
                    current.val = temp;
                }
                index = index.next;
            }

            current = current.next;
        }

        return head;
    }
}
