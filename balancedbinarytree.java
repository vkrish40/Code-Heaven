/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Worst case running time: O(n)

Generally would be a lot faster considering the approach that's been used. 

*/
class Solution {
    
    boolean balanced;
    
    public int check(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=0,right=0,diff=0;
        left=check(root.left);
        if(balanced==true)
        {
            right=check(root.right);
            diff=Math.abs(left-right);
        }
        
        if(balanced!=false && diff>1)
            balanced=false;
        
        return Math.max(left,right)+1;
            
        
    }
    public boolean isBalanced(TreeNode root) {
        
        balanced=true;
        
        check(root);
        
        return balanced;
    }
}