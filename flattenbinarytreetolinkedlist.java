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


/* Better SOlution using Morris Algorithm */

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
    public void flatten(TreeNode root) {
        
        TreeNode current = root;
        while(current!=null)
        {
            if(current.left==null)
            {
                current = current.right;
            }
            else
            {
                TreeNode present = current.left;
                while(present.right!=null && present.right!=current)
                {
                    present = present.right;
                }
                
                if(present.right==null)
                {
                    present.right = current; 
                    current = current.left;
                }
                else
                {
                    present.right = current.right;
                    current.right = current.left;
                    current.left = null;
                    current = present.right;
                }
            }
        }
        
    }
}