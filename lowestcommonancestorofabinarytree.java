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
    public TreeNode compare(TreeNode root, TreeNode p, TreeNode q)
    {   
        if(root==p ||root==q)
            return root;
        if(root==null)
            return root;
        root.left=compare(root.left, p, q); 
        root.right=compare(root.right, p, q);
        if(root.left!=null && root.right!=null)
            return root;
        if(root.left!=null)
            return root.left;
        if(root.right!=null)
            return root.right;
        return null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode ancestor;        
        ancestor=compare(root, p , q);        
        return ancestor;    
    }
}