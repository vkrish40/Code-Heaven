/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode comp;
    public boolean check(ListNode root)
    {
        if(root==null)
        {
            return true;
        }
        
        boolean ans = check(root.next);
        if(ans==false)
            return false;
        if(root.val!=comp.val)
            return false;
        comp=comp.next;
        return true;            
    }
    public boolean isPalindrome(ListNode head) {
    
        comp=head;
        boolean ans=check(head);
        return ans;
    }
}