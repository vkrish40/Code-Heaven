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
    
    public int search(int[] post, int val, int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            if(post[i]==val)
                return i;
        }
        return -1;
    }
    
    public TreeNode construct(int[] pre, int[] post, int start, int end)
    {
        if(pre_index>=pre.length)
            return null;
        
        int val = pre[pre_index];
        int index = search(post, val, start, end);
        
        if(index==-1)
            return null;
        pre_index++;
        TreeNode root=new TreeNode(val);
        
        root.left=construct(pre, post, start, index);
        root.right=construct(pre, post, start, index);
        
        return root;
    }
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        
        return construct(pre, post, 0, post.length);
        
    }
}