/*LFU Cache

It's not the most efficient lfucache code. It's worst time complexity for both put and get operations is O(n).
O(1) can be achieved for both the operations.

*/




Class Node{
    
    int val;
    int count;
    int key;
    Node prev;
    Node next;
}

class LFUCache {
    
    Map<Integer,Node> map=new HashMap<>();
    int max_size;
    Node removal;
    Node head;
    int tele=0;
    

    public LFUCache(int capacity) {
        max_size=capacity;
    }
    
    public void compare(Node node,Node head)
    {
        Node temp;
        if(this.head.count<node.count)
        {
            this.head=node;
            temp=node;
            node=head;
            
        }
        else if(this.head.count<=head.count)
        {
            this.head=head;
            temp=head;
        }
        
        while(temp!=null)
        {
            if(temp.count>node.count)
            {
                node.prev=temp.prev;
                if(temp.prev!=null)
                    temp.prev.next=node;
                temp.prev=node;
                if(node.next!=null)
                    node.next.prev=temp;
                node.next=temp;
                temp=node;                
            }
            removal=temp;
            temp=temp.prev;    
        }       
    }
    
    public int get(int key) {
               
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.count++;
            if(node.count==head.count)
            {
                head.prev=node.prev;
                node.prev=head;
                head.next=node;
                head=node;
                compare(node,head);
            }
            else
                compare(node,head);
            return node.val;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        
        if(tele==max_size)
        {
            map.remove(removal.key);
            removal.next.prev=null;
            removal=removal.next;
            tele--;
        }
        
        Node node=new Node();
        node.val=value;
        node.key=key;
        node.count=1;
        map.put(key,node);
    
        
        if(tele==0)
        {
            head=node;
            removal=node;
            tele++;
        }           
        else
        {
            head.next=node;
            node.prev=head;
            //head=node;
            if(node.count==head.count)
                head=node;
            else
                compare(node,head);
            tele++;
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */