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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return Arrays.asList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>(); 
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=1;i<=len;i++)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            ans.add(list);
        }
        
        return ans;
        
    }
}