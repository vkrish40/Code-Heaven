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

	if(node==null)
	    return node;
        
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


Alternate Solution

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return node;
        
        Map<Node,Node> map = new HashMap<>();
        
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.offer(node);
        
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            Node new_node = new Node(temp.val);
            map.put(temp, new_node);
            Iterator<Node> itr = temp.neighbors.iterator();
            while(itr.hasNext())
            {
                Node child = itr.next();
                if(!map.containsKey(child))
                    queue.offer(child);
            }
        }
        
        queue.offer(node);
        
        Set<Node> set = new HashSet<>();
        set.add(node);
        
        while(!queue.isEmpty())
        {
            Node original = queue.poll();
            Node copy = map.get(original);
            Iterator<Node> itr = original.neighbors.iterator();
            while(itr.hasNext())
            {
                Node child = itr.next();
                Node child_copy = map.get(child);
                copy.neighbors.add(child_copy);
                if(!set.contains(child))
                {
                    set.add(child);
                    queue.offer(child);
                }
            }
        }
        
        return map.get(node);
        
    }
}