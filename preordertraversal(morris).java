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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        /*Morris Preorder Traversal*/
        
        if(root==null)
            return Arrays.asList();
        
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        
        while(temp!=null)
        {
            if(temp.left==null)
            {
                list.add(temp.val);
                temp=temp.right;
            }
            else
            {
                TreeNode current = temp.left;
                while(current.right!=null && current.right!=temp)
                {
                    current=current.right;
                }
                if(current.right==null)
                {
                    list.add(temp.val);
                    current.right=temp;
                    temp=temp.left;
                }
                else
                {
                    current.right=null;
                    temp=temp.right;
                }
                
            }               
            
        }
        
        return list;
    
        
    }
}