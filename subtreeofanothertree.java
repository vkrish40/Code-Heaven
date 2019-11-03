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

/*Linear Time approach using StringBuilder and KMP substring search algorithm*/

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
    public boolean kmp(StringBuilder haystack, StringBuilder needle) {
        
        int[] track = new int[needle.length()];
        
        int i=0;
        int j=1;
        track[0]=0;
        
        while(j<needle.length())
        {
            if(needle.charAt(i)==needle.charAt(j))
            {
                i++;
                track[j]=i;
                j++;
            }
            else if(i==0)
            {
                track[j]=0;
                j++;
            }
            else
            {
                i=track[i-1];
            }
        }
        
        i=0;
        j=0;
        while(j<haystack.length())
        {
            if(haystack.charAt(j)==needle.charAt(i))
            {
                if(i==needle.length()-1)
                    return true;
                j++;
                i++;
            }
            else if(i==0)
            {
                j++;
            }
            else
            {
                i=track[i-1];
            }
        }
        
        return false;
    }

    public StringBuilder preorder(TreeNode root, StringBuilder str)
    {
        if(root==null)
        {
            return str.append("null");
        }
        str.append("*");
        str.append(root.val);
        str.append("*");
        str=preorder(root.left,str);
        str=preorder(root.right,str);
        
        return str;        
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        bigtree = new StringBuilder();
        smalltree = new StringBuilder();
        
        bigtree=preorder(s, bigtree);
        smalltree=preorder(t, smalltree);
        
        return kmp(bigtree, smalltree);
    }
}