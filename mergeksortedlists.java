/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp=null,root=null;
        Queue<Integer> queue=new PriorityQueue();
        for(int i=0;i<lists.length;i++)
        {
            temp=lists[i];
            while(temp!=null)
            {
                queue.offer(temp.val);
                temp=temp.next;
            }
        }
        root=new ListNode(-1);
        ListNode head=root;
        while(!(queue.isEmpty()))
        {
            root.next = new ListNode(queue.poll());
            root = root.next;    
        }
        return head.next;
    }
}