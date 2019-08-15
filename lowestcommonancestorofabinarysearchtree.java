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
        TreeNode ans=null;
        if(root==p || root==q)
        {
            return root;
        }
        if(root==null)
        {
            return root;
        }
        if((p.val<root.val || q.val<root.val) && (p.val>root.val || q.val>root.val))
        {
            return root;
        }        
        if(p.val<root.val && q.val<root.val)
        {
            ans=compare(root.left, p, q);
        }
        if(p.val>root.val && q.val>root.val)
        {
            ans=compare(root.right, p, q);
        }
        return ans;                
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return compare(root, p, q);
        
    }
}