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
    public int findBottomLeftValue(TreeNode root) {
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        int bottomLeftValue = root.val;
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int len = queue.size();
            for(int i=0;i<len;i++)
            {
                TreeNode node = queue.poll();
                if(i==0)
                    bottomLeftValue = node.val;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);                
            }
        }
        
        return bottomLeftValue;        
    }
}