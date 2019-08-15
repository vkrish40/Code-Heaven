/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        Map<ListNode,ListNode> map=new HashMap<>();
        ListNode temp=head;
        while(temp!=null)
        {
            if(map.containsKey(temp))
                return map.get(temp);
            map.put(temp,temp);
            temp=temp.next;
        }
        return null;
        
    }
}