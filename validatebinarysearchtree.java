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
    public boolean check_bst(TreeNode root, int min, int max)
    {
        if(root==null)
            return true;
        boolean left = check_bst(root.left, min, root.val);
        boolean right = check_bst(root.right, root.val, max);
        
        if(root.val>min && root.val<max && left && right)
            return true;
        return false;
        
    }
    
    public boolean isValidBST(TreeNode root) {
        
        return check_bst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);       
        
    }
}