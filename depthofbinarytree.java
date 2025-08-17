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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return heightfind(root.right, root.left, 1); // start height from 1 since root is not null
    }

    private int heightfind(TreeNode right, TreeNode left, int height) {
        if (right == null && left == null) {
            return height;
        } else if (right != null && left == null) {
            return heightfind(right.right, right.left, height + 1);
        } else if (right == null && left != null) {
            return heightfind(left.right, left.left, height + 1);
        } else { 
            int rightHeight = heightfind(right.right, right.left, height + 1);
            int leftHeight = heightfind(left.right, left.left, height + 1);
            return Math.max(rightHeight, leftHeight);
        }
    }
}
