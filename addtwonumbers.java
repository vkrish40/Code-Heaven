/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode add(ListNode root, int digit)
        {
            ListNode temp=new ListNode(digit);
            temp.next=null;
            if(root!=null)
            {
                root.next=add(root.next,digit);
            }
            else
            {
                root=temp;
            }
            return root;
        }
        
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int sum = 0, carry=0;
        
        ListNode root=null;             
        
        while(l1!=null || l2!=null)
        {
            if(l1==null)
            {
                sum=carry+l2.val;
                l2=l2.next;
            }
                
            else if(l2==null)
            {
                sum=carry+l1.val;
                l1=l1.next;
            }                
            else
            {
                sum=carry+l1.val+l2.val;
                l1=l1.next;
                l2=l2.next;
            }
                
            if(sum>9)
            {
                carry=1;
                root=add(root,(sum-10));
            }
            else
            {
                carry=0;
                root=add(root,sum);
            }            
        }
        if(carry==1)
        {
            root=add(root,carry);
        }
        return root;
    }
}