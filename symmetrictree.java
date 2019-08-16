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
    
    public boolean check(TreeNode left, TreeNode right)
    {
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        else if(left.val==right.val && check(left.left,right.right) && check(left.right,right.left))
            return true;
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null)
            return true;
        return check(root.left,root.right);
    }
}