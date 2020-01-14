/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
        
    public List<List<Integer>> levelOrder(Node root) {
        
        if(root==null)
            return Arrays.asList();
        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=1;i<=len;i++)
            {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);                
            }
            ans.add(list);
        }
        
        return ans;
        
    }
}