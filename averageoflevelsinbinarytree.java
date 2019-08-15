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
    public List<Double> averageOfLevels(TreeNode root) {
       
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        
        double sum=0;
        int count=1;
        TreeNode temp;
        if(root!=null)
        {
            queue1.offer(root);
            queue2.offer(root);
        }
        while(!queue1.isEmpty())
        {
            queue1.clear();
            while(!queue2.isEmpty())
            {
                temp=queue2.poll();
                sum=sum+temp.val;
                if(temp.left!=null)
                    queue1.offer(temp.left);
                if(temp.right!=null)
                    queue1.offer(temp.right);            
            }
            res.add(sum/count);
            queue2.addAll(queue1);
            count=queue1.size();
            sum=0;
        } 
        return res;
    }
}