class Node
{
    int key;
    int value;
    int count;
    Node next;
    Node prev;
    public Node(int key, int value, int count)
    {
        this.key = key;
        this.value = value;
        this.count = count;
    }
}
class doublylinkedlist
{
    Node head;
    Node tail;
    public doublylinkedlist()
    {
        head = new Node(-1,-1,-1);
        tail = new Node(-1,-1,-1);
        head.next = tail;
        tail.prev = head;
    }
}

class LFUCache {
    
    Map<Integer, doublylinkedlist> frequency = new HashMap<>();
    Map<Integer, Node> map = new HashMap<>();
    int capacity = 0;
    int max_frequency = 0;
    int size = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity; 
    }
    
    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void remove(doublylinkedlist list)
    {
        map.remove(list.tail.prev.key);
        list.tail.prev.prev.next = list.tail;
        list.tail.prev = list.tail.prev.prev; 
    }
    public void add(doublylinkedlist list, Node node)
    {
        node.next = list.head.next;
        node.prev = list.head;
        node.next.prev = node;
        list.head.next = node;
    }
    
    public int get(int key) {
        if(capacity==0)
            return -1;
        Node temp;
        if(map.containsKey(key))
        {
            temp = map.get(key);
            remove(temp);
            temp.count++;
            max_frequency = Math.max(temp.count,max_frequency);
            doublylinkedlist mod_list = frequency.getOrDefault(temp.count, new doublylinkedlist());
            add(mod_list, temp);
            frequency.put(temp.count,mod_list);
            return temp.value;
        }
        
        return -1;
        
    }
    
    public void put(int key, int value) {
        
        if(capacity==0)
            return;
        
        Node temp;
        
        if(map.containsKey(key))
        {
            temp = map.get(key);
            temp.value = value;
            remove(temp);
            temp.count++;
            max_frequency = Math.max(temp.count,max_frequency);
            doublylinkedlist mod_list = frequency.getOrDefault(temp.count, new doublylinkedlist());
            add(mod_list, temp);
            frequency.put(temp.count,mod_list);
        }
        else
        {
            if(size==capacity)
            {
                for(int i=1;i<=max_frequency;i++)
                {
                    if(frequency.get(i)!=null && frequency.get(i).head.next!=frequency.get(i).tail)
                    {
                        doublylinkedlist dll = frequency.get(i);
                        remove(dll);
                        size--;
                        break;
                    }
                }
            }
            temp = new Node(key, value, 1);
            size++;            
            map.put(key, temp);
            max_frequency = Math.max(1,max_frequency);
            doublylinkedlist list = frequency.getOrDefault(temp.count, new doublylinkedlist());
            add(list, temp); 
            frequency.put(temp.count,list);            
        }
            
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */