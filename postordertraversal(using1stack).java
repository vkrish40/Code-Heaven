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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        /* Postorder using 1 stack and set*/
        
        /*if(root==null)
            return Arrays.asList();
        
        List<Integer> list = new ArrayList<>();
        
        Set<TreeNode> set = new HashSet<>();
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        stack.push(root);
        set.add(root);
        int count = 0;
        
        while(!stack.isEmpty())
        {
            TreeNode temp = stack.peek();
            
            if(temp.right!=null && !set.contains(temp.right))
            {
                stack.push(temp.right);
                set.add(temp.right);
                count++;
            }
            if(temp.left!=null && !set.contains(temp.left))
            {
                stack.push(temp.left);
                set.add(temp.left);
                count++;
            }
            if(count==0)
            {
                list.add(stack.pop().val);
            }       
            count=0;
        }
        
        return list; */
        
        /*Postorder using 1 stack*/
        
        if(root==null)
            return Arrays.asList();
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        if(root.right!=null)
            stack.push(root.right);
        stack.push(root);
        current = root.left;
        
        while(!stack.isEmpty())
        {
            if(current==null)
            {
                TreeNode temp = stack.pop();
                if(!stack.isEmpty() && temp.right==stack.peek())
                {
                    current = stack.pop();
                    stack.push(temp);
                }
                else
                {
                    list.add(temp.val);
                    current=null;
                }
            }
            else
            {
                if(current.right!=null)
                    stack.push(current.right);
                stack.push(current);
                current=current.left;
            }            
        }
        
        return list;
        
    }
}