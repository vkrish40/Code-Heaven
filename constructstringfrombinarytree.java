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
    
    public void preorder(TreeNode root, StringBuilder strb)
    {
        if(root==null)
            return;
        strb.append(root.val);
        if(root.left==null && root.right!=null)
            strb.append("()");
        if(root.left!=null)
        {
            strb.append("(");
            preorder(root.left, strb);
            strb.append(")");
        }
        if(root.right!=null)
        {
            strb.append("(");
            preorder(root.right, strb);
            strb.append(")");
        }
    }
    
    public String tree2str(TreeNode t) {
        
        if(t==null)
            return "";
        
        StringBuilder strb = new StringBuilder();
        
        preorder(t, strb);
        
        return strb.toString();
        
    }
}