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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>(); // This is the output arraylist
        rightView(root,result,0);
        return result;
    }
    private void rightView(TreeNode current, List<Integer> result,int depth){
        if(current == null){
            return;
        }
        if(depth == result.size()){
            result.add(current.val);
        }
        rightView(current.right,result,depth+1);
        rightView(current.left,result,depth+1);
    }
}