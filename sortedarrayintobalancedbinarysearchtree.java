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
    
    public TreeNode construct(int[] nums, int start, int end)
    {
        if(end<start || start>end)
            return null;
        int mid=(start+end)/2;
        
        TreeNode root=new TreeNode(nums[mid]);
        root.left=construct(nums, start, mid-1);
        root.right=construct(nums, mid+1, end);
        
        return root;
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return construct(nums, 0, nums.length-1);
        
    }
}

/*

Important Note: To convert any Binary Search Tree into a Balanced Binary Search Tree,

First do Inorder traversal and get the sorted array or list in the ascending order, then you can 

use the approach described above to build a Balanced Binary Search Tree.

*/