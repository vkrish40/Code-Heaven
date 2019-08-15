/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0;
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode nod=head;
        ListNode node1=null,node2=null;
        while(nod!=null)
        {
            ++i;
            map.put(i,nod);
            nod=nod.next;
        }
        int temp=i-n;
        
        if(temp==0 && i==1)
            head=null;
        else if(temp==0 && i==n)
            head=head.next;
        else if(n==1)
        {
            node1=map.get(temp);
            node1.next=null;
        }
        else
        {
            node1=map.get(temp);
            node2=map.get(temp+2);
            node1.next=node2;
        }
        return head;
    }
}