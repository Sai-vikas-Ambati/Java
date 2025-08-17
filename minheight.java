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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        return depth(root, 1); 
    }

    private int depth(TreeNode node, int currentDepth) {
        if (node == null) {
            return Integer.MAX_VALUE; 
        }

        if (node.left == null && node.right == null) {
            return currentDepth;
        }

        int leftDepth = depth(node.left, currentDepth + 1);
        int rightDepth = depth(node.right, currentDepth + 1);

        return Math.min(leftDepth, rightDepth);
    }
}
