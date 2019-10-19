/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root==null)
            return sum;
        if(root.left!=null && root.left.left==null && root.left.right==null)
            sum+=root.left.val;
        sum=sumOfLeftLeaves(root.left);
        sum=sumOfLeftLeaves(root.right);
        
        return sum;      
    }
}