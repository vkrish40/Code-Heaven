/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp!=null && temp.next!=null)
        {
            ListNode root = temp.next;
            temp.next = temp.next.next;
            root.next = temp;
            
            if(prev == null)
            {
                head = root;
                prev = temp;
                temp = temp.next;
                continue;                
            }
            prev.next = root;
            prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
}