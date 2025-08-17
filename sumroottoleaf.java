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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentNumber) {
        if (node == null) return 0;
        
        // Update the current number formed by this path
        currentNumber = currentNumber * 10 + node.val;
        
        // If leaf node, return the current number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }
        
        // Recursively calculate sum for left and right subtrees
        return dfs(node.left, currentNumber) + dfs(node.right, currentNumber);
    }
}
