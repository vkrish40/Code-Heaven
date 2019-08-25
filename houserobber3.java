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
    
    public int[] postorder(TreeNode root)
    {
        if(root==null)
            return new int[2];
        int[] left=postorder(root.left);
        int[] right=postorder(root.right);
        int[] result=new int[2];
        
        int temp=left[0]+right[0];
        
        result[0]=Math.max(temp,root.val+left[1]+right[1]);
        
        result[1]=temp;
        
        return result;
               
    }
    
    public int rob(TreeNode root) {
        
        int ans[]=postorder(root);
        
        return ans[0];
        
    }
}

/* Alternate approach

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
class Solution {
    
    public int[] postorder(TreeNode root)
    {
        if(root==null)
            return new int[2];
        int[] left=postorder(root.left);
        int[] right=postorder(root.right);
        int[] result=new int[2];
        
        result[0]=root.val+left[1]+right[1];
        
        result[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        
        return result;
               
    }
    
    public int rob(TreeNode root) {
        
        int ans[]=postorder(root);
        
        return Math.max(ans[0],ans[1]);
        
    }
}
*/