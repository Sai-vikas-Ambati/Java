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
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Recursively flatten the left and right subtree
        flatten(root.left);
        flatten(root.right);

        // Store the left and right children
        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;

        // Set the left to null and right to the flattened left subtree
        root.left = null;
        root.right = leftSubtree;

        // Traverse to the end of the new right subtree and attach the original right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = rightSubtree;
    }
}
