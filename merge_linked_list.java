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
    public ListNode mergeKLists(ListNode[] lists) {
        // Base case: if the input is empty, return null
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Start the merge process recursively
        return merge(lists, 0, lists.length - 1);
    }

    // Merge lists from the left index to the right index
    private ListNode merge(ListNode[] lists, int left, int right) {
        // Base case: if there is only one list, return it
        if (left == right) {
            return lists[left];
        }
        
        // Find the middle index
        int mid = left + (right - left) / 2;
        
        // Recursively merge the left and right halves
        ListNode leftMerged = merge(lists, left, mid);
        ListNode rightMerged = merge(lists, mid + 1, right);
        
        return mergeTwoLists(leftMerged, rightMerged);
    }

    // Merge two sorted linked lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the merge process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // If one list is longer, append the rest of it
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        
        return dummy.next;
    }
}