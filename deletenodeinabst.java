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
    
    public int minRightTree(TreeNode root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        int min_val=0;
        while(root!=null)
        {
            min_val=root.val;
            root=root.left;
        }
        return min_val;
    }
    
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null)
            return null;
        if(root.val>key)
        {
            root.left=deleteNode(root.left, key);
        }
        else if(root.val<key)
        {
            root.right=deleteNode(root.right, key);
        }
        else
        {
            int value = minRightTree(root.right);
            if(value==Integer.MIN_VALUE)
                root=root.left;
            else
            {
                root.val=value;
                root.right=deleteNode(root.right,value);
            }                
        }
        
        return root;
        
    }
}