/******************************************************************************

                Implementing LRU CACHE using doubly linked list and HashMap 

*******************************************************************************/
import java.util.*;
class Node
{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

public class Main
{
    Map<Integer,Node> map;
    Node head;
    Node tail;
    
    public void put(int key, int value)
    {
        Node node;
        if(map.containsKey(key))
        {
            node = map.get(key);
            node.value = value;
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        else
        {
            node = new Node(key,value);
            if(map.size()==5)
            {
                map.remove(tail.prev.key);
                tail.prev.prev.next=tail;
                tail.prev = tail.prev.prev;
            }
                
        }
        head.next.prev=node;
        node.next=head.next;
        node.prev=head;
        head.next=node;
        map.put(key,node);
    }
    
    public int get(int key)
    {
        if(!map.containsKey(key))
        {
            return -1;
        }
        else
        {
            Node node = map.get(key);
            node.prev.next=node.next;
            node.next.prev=node.prev;
            head.next.prev=node;
            node.next=head.next;
            node.prev=head;
            head.next=node;
            return node.value;
        }
    }
    
    public void run()
    {
        map = new HashMap<>();
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        put(1,1);
        put(2,3);
        put(3,4);
        put(4,7);
        put(6,10);
        System.out.println("Key 1: " + get(1));
        System.out.println("Key 3: " + get(3));
        put(1,5);
        put(12,7);
        put(5,2);
        System.out.println("Key 4: " + get(4));
        System.out.println(map);
    }
    
	public static void main(String[] args) {
		
		Main obj = new Main();
		
		obj.run();
	}
}
