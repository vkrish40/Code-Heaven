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
    
    int max;
    
    public int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        
        max=max<(root.val+left+right)?(root.val+left+right):max;
        max=max<root.val+left?root.val+left:max;
        max=max<root.val+right?root.val+right:max;
        max=max<root.val?root.val:max;    
        
        int val_ret=root.val;
        val_ret=val_ret<root.val+left?root.val+left:val_ret;
        val_ret=val_ret<root.val+right?root.val+right:val_ret;
        
        return val_ret;  
    }
    
    public int maxPathSum(TreeNode root) {
        
        max=root.val;
        
        dfs(root);
        
        return max;
        
    }
}