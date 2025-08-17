/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Recursively get the max gain from left and right, discard negatives
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Current path price (could be a peak in the middle of the path)
        int priceNewPath = node.val + leftGain + rightGain;

        // Update global max if this path is better
        maxSum = Math.max(maxSum, priceNewPath);

        // For recursion: return max gain including this node and one subtree
        return node.val + Math.max(leftGain, rightGain);
    }
}
