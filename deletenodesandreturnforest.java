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
    
    List<TreeNode> ans;
    Set<Integer> set;
    public TreeNode check(TreeNode root)
    {
        if(root==null)
            return root;
        if(set.contains(root.val))
        {
            root.left = check(root.left);
            root.right = check(root.right);
            if(root.left!=null)
                ans.add(root.left);
            if(root.right!=null)
                ans.add(root.right);
            return null;
        }
        root.left = check(root.left);
        root.right = check(root.right);
        
        return root;        
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        if(root==null)
            return Arrays.asList();
        
        set = new HashSet<>();
        ans = new ArrayList<>();
        
        for(int i=0;i<to_delete.length;i++)
            set.add(to_delete[i]);
        if(!set.contains(root.val))
            ans.add(root);
        check(root);
        
        return ans;        
    }
}