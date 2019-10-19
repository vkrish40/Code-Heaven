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
    
    int post_index;
    
    public int search(int[] inorder, int val, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            if(inorder[i]==val)
                return i;
        }        
        return -1;        
    }
    
    public TreeNode construct(int[] inorder, int[] postorder, int start, int end)
    {
        if(post_index<0)
            return null;
        
        int val=postorder[post_index];
        int index = search(inorder, val, start, end);
        if(index==-1)
            return null;
        post_index--;
        
        TreeNode root=new TreeNode(val);
        root.right=construct(inorder, postorder, index+1, end);
        root.left=construct(inorder, postorder, start, index);
        
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        post_index=postorder.length-1;        
        return construct(inorder, postorder, 0, inorder.length);
        
    }
}