class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        while (left < right) {
            swap(head, left, right);
            left++;
            right--;
        }
        return head;
    }
    
    private void swap(ListNode head, int left, int right) {
        ListNode leftNode = head;
        ListNode rightNode = head;
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }
        for (int i = 1; i < right; i++) {
            rightNode = rightNode.next;
        }
        int temp = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = temp;
    }
}
