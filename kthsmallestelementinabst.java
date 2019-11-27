/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int index = 0;
    int val = 0;
    boolean found;
    
    public void inorder(TreeNode root, int k)
    {
        if(root==null)
            return;
        
        inorder(root.left, k);
        if(found)
            return;            
        if(++index==k)
        {
            val = root.val;
            found = true;
            return;
        }
        inorder(root.right, k);
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        
        /*Linear time approach*/
        
        inorder(root, k);
        
        return val;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /* N log k time complexity, where N is the total number of nodes in the BST and k is the kth smallest element */
    Queue<Integer> queue;
    
    public void preorder(TreeNode root, int k)
    {
        if(root==null)
            return;
        if(!queue.isEmpty() && queue.size()==k && root.val<queue.peek())
        {
            queue.poll();
            queue.offer(root.val);
        }
        else if(queue.size()<k)
        {
            queue.offer(root.val);
        }
        preorder(root.left, k);
        preorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        
        queue = new PriorityQueue(k, Collections.reverseOrder());
        
        preorder(root, k);
        
        return queue.poll();
    }
}