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
    
    public TreeNode check(TreeNode root)
    {
        if(root==null)
            return root;
        
        TreeNode left_last = check(root.left);
        TreeNode right_last = check(root.right);
        
        if(left_last==null && right_last==null)
            return root;
        if(left_last!=null)
        {
            TreeNode temp = root.right;
            root.right = root.left;
            left_last.right = temp;
            root.left = null;
            if(right_last==null)
                return left_last;
        }
        
        return right_last;
    }
    
    public void flatten(TreeNode root) {
        
        if(root==null)
            return;
        
        check(root);        
    }
}