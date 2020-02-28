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
    
    /*Will do in constant space using Morris Inorder Traversal*/
    
    TreeNode first;
    TreeNode last;
    
    public void morris(TreeNode root)
    {
        TreeNode current = root;
        TreeNode predecessor = null;
        
        while(current!=null)
        {
            if(predecessor!=null && predecessor.val>current.val)
            {
                if(first==null)
                {
                    first = predecessor;
                    last = current;
                }
                else
                {
                    last = current;
                }
            }
            
            if(current.left==null)
            {
                predecessor = current;
                current = current.right;
            }                
            else
            {
                TreeNode prev = current.left;
                while(prev.right!=null && prev.right!=current)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right = current;
                    current=current.left;
                }
                else
                {
                    prev.right=null;
                    predecessor = current;
                    current=current.right;
                }
            }            
        }
    }
    public void recoverTree(TreeNode root) {
        
        morris(root);        
        int value = first.val;
        first.val = last.val;
        last.val = value;
        
    }
}