/*M - no. of nodes in the big tree, N - no. of nodes in the smaller tree

Time Complexity: O(MN)

 */

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
    
    TreeNode subtree;
    
    public boolean check(TreeNode root, TreeNode sub)
    {
        if(root==sub)
            return true;
        else if(root==null || sub==null)
            return false;
        else if(root.val==sub.val)
        {
            boolean left=check(root.left, sub.left);
            boolean right=check(root.right, sub.right);
            if(left && right)
                return true;            
        }
        if(sub==subtree)
        {
            boolean ans1=check(root.left,sub);
            boolean ans2=check(root.right,sub);
            if(ans1 || ans2)
                return true;
        }
        return false;
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        subtree=t;
        
        return check(s,t);
    }
}



/*Linear time approach: M - no. of nodes in the big tree, N - no. of nodes in the smaller tree

Time Complexity: O(M)

 */

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
    
    StringBuilder bigtree;
    StringBuilder smalltree;

    public StringBuilder preorder(TreeNode root, StringBuilder str)
    {
        if(root==null)
        {
            return str.append("null");
        }
        str.append(root.val);
        str=preorder(root.left,str);
        str=preorder(root.right,str);
        
        return str;        
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        bigtree = new StringBuilder();
        smalltree = new StringBuilder();
        
        bigtree=preorder(s, bigtree);
        smalltree=preorder(t, smalltree);
        
        String small =  new String(smalltree);
        
        int index=bigtree.indexOf(small);
        
        System.out.println(bigtree);
        System.out.println(smalltree);
        
        
        if(index==-1)
            return false;
        return true;
        
    }
}