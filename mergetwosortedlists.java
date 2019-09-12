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