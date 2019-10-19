/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)
            return null;
        ListNode prev = null;
        ListNode temp = head;
        
        while(temp!=null && temp.next!=null)
        {
            if(temp.val==temp.next.val)
            {
                temp=temp.next;
                while(temp!=null && temp.next!=null && temp.val==temp.next.val)
                {
                    temp=temp.next;
                }
                temp=temp.next;
                continue;
            }
            if(prev==null)
            {
                prev=temp;
                head=temp;
                temp=temp.next;
                continue;
            }
            prev.next=temp;
            prev=prev.next;
            temp=temp.next;
        }
        if(prev==null)
            head=temp;
        else
            prev.next=temp;
        
        return head;
    }
}