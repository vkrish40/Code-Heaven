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
    
    int pre_index=0;
    
    public int search(int[] inorder, int val, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            if(val==inorder[i])
                return i;
        }
        return -1;
    }
    
    public TreeNode construct(int[] preorder, int[] inorder, int start, int end)
    {
        if(pre_index>=preorder.length)
            return null;
        
        int val=preorder[pre_index];
        int in_index=search(inorder, val, start, end);
        
        if(in_index==-1)
            return null; 
        
        TreeNode root=new TreeNode(val);
        pre_index++;
        
        root.left=construct(preorder, inorder, start, in_index);
        root.right=construct(preorder, inorder, in_index+1, end);
        
        return root;
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return construct(preorder, inorder, 0, inorder.length);
        
    }
}