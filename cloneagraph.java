/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        
        Map<Integer,Node> map=new HashMap<>();
        
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.offer(node);
        
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            if(!map.containsKey(temp.val))
            {
                Node root = new Node();
                map.put(temp.val,root);
                if(temp.neighbors!=null)
                {
                    Iterator<Node> itr = temp.neighbors.iterator();
                    while(itr.hasNext())
                    {
                        queue.offer(itr.next());
                    }
                }
            }
        }
    
        queue.offer(node);
        Set<Node> visited = new HashSet<>(); 
        
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            Node root = map.get(temp.val);
            root.val = temp.val;
            
            if(!visited.contains(temp))
            {
                visited.add(temp);
                
                if(temp.neighbors!=null)
                {
                    List<Node> list = new ArrayList<>();
                    Iterator<Node> itr = temp.neighbors.iterator();
                    while(itr.hasNext())
                    {
                        Node extra = itr.next();
                        Node nod = map.get(extra.val);
                        list.add(nod);
                        queue.offer(extra);                        
                    }
                    root.neighbors = list;
                }
                
            }
            
        }
               
        return map.get(node.val);
        
    }
}