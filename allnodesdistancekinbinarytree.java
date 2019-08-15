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
    Map<TreeNode,TreeNode>map;
    
    public void preorder(TreeNode root)
    {
        if(root==null)
            return;
        if(root.left!=null)
        {
            map.put(root.left,root);
            preorder(root.left);
        }
        if(root.right!=null)
        {
            map.put(root.right,root);
            preorder(root.right);
        }      
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        if(root==null || target==null)
            return Arrays.asList();
        
        map=new HashMap<>();
        
        map.put(null,root);
        
        preorder(root);
        
        Queue<TreeNode> queue=new ArrayDeque<>();
        Set<Integer> set=new HashSet<>();
        queue.offer(target);
        set.add(target.val);
        int level=0;
        
        while(level!=K && !queue.isEmpty())
        {
            int len=queue.size();
            for(int i=0;i<len;i++)
            {
                TreeNode temp=queue.poll();
                if(temp.left!=null && !set.contains(temp.left.val))
                {
                    queue.offer(temp.left);
                    set.add(temp.left.val);
                }
                if(temp.right!=null && !set.contains(temp.right.val))
                {
                    queue.offer(temp.right);
                    set.add(temp.right.val);
                }
                if(map.get(temp)!=null && !set.contains(map.get(temp).val))
                {
                    queue.offer(map.get(temp));
                    set.add(map.get(temp).val);
                }              
            }
            level++;
        }
        
        List<Integer> list=new ArrayList<>();
        
        Iterator<TreeNode> itr=queue.iterator();
        while(itr.hasNext())
        {
            TreeNode temp=itr.next();
            list.add(temp.val);
        }
        
        return list;
        
        
        /* Debugging the map
        
        Set<TreeNode> set=map.keySet();
        Iterator<TreeNode> itr=set.iterator();
        while(itr.hasNext())
        {
            TreeNode temp=itr.next();
            if(temp==null)
                System.out.println("GODFATHER" + " -> " + map.get(temp).val);
            else 
                System.out.println(temp.val + " -> " + map.get(temp).val);
        }*/
        
        
    }
}