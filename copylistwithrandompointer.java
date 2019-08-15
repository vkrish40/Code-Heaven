/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null)
            return head; 
        
        Map<Node,Node> map=new HashMap<>();
        
        Node temp=head;
        
        while(temp!=null)
        {
            map.put(temp,new Node());  
            temp=temp.next;
        }
        
        temp=head;
        
        while(temp!=null)
        {
            Node copy=map.get(temp);
            Node next=map.get(temp.next);
            Node random=map.get(temp.random);
            copy.val=temp.val;
            copy.next=next;
            copy.random=random;
            temp=temp.next;
        }
        
        return map.get(head);
        
    }
}