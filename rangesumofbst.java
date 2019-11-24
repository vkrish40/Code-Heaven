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
    int sum = 0;
    
    public void calculate(TreeNode root, int L, int R)
    {
        if(root==null)
            return;  
        if(root.val<L)
        {
            rangeSumBST(root.right, L, R);            
        }
        else if(root.val>R)
        {
            rangeSumBST(root.left, L, R);
        }
        else
        {
            sum+=root.val;
            rangeSumBST(root.right, L, R);
            rangeSumBST(root.left, L, R);
        }
                
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        calculate(root, L, R);
        return sum;
        
    }
}