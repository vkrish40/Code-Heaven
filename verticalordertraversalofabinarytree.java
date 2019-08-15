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
    Map<Integer,Queue<Integer>> map;
    
    public void vertical_traversal(TreeNode root, int value)
    {
        if(root==null)
            return;
        Queue<Integer> queue=map.getOrDefault(value,new PriorityQueue<Integer>());
        queue.offer(root.val);
        map.put(value,queue);
        vertical_traversal(root.left,value-1);
        vertical_traversal(root.right,value+1);
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        map=new TreeMap<>();
        vertical_traversal(root, 0);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        Set<Map.Entry<Integer,Queue<Integer>>> set=map.entrySet();
        Iterator<Map.Entry<Integer,Queue<Integer>>> itr=set.iterator();
        while(itr.hasNext())
        {
            Map.Entry<Integer,Queue<Integer>> me=itr.next();
            List<Integer> list=new ArrayList<>();
            int size=me.getValue().size();
            for(int i=0;i<size;i++)
            {
                list.add(me.getValue().poll());
            }
            ans.add(list);
        }
        return ans;
        
    }
}