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
    
    
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
        
        Queue<TreeNode> queue=new ArrayDeque<>();
        
        List<Integer> list=new ArrayList<>();
        
        queue.offer(root);
        
        TreeNode temp;
        
        while(!queue.isEmpty())
        {
            int length=queue.size();
            for(int i=1;i<=length;i++)
            {
                temp=queue.poll();
                if(i==length)
                    list.add(temp.val);
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);              
            }
        }
        
        return list;
        
        
        
    }
}