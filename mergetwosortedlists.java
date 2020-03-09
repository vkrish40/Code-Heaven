/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

Constant Space Solution

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode root = head;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                head.next = l1;
                l1 = l1.next;
            }
            else
            {
                head.next = l2;
                l2 = l2.next;
            }
            
            head = head.next;
        }
        
        if(l1!=null)
            head.next = l1;
        else if(l2!=null)
            head.next = l2;
        
        return root.next;
        
    }
}


Alternate Solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null && l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode temp=new ListNode(-1);
        
        if(l1.val<=l2.val)
        {
            temp.val=l1.val;
            l1=l1.next;
        }
        else
        {
            temp.val=l2.val;
            l2=l2.next;
        }
        
        temp.next=mergeTwoLists(l1,l2);
        
        return temp;
        
        
    }
}