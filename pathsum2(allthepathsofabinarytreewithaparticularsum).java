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
    
    List<List<Integer>> ans;
    
    public void dfs(TreeNode root, int sum, int currentsum, List<Integer> list)
    {
        if(root==null)
            return;
        else if(root.left==null && root.right==null && currentsum+root.val==sum)
        {
            list.add(root.val);
            ans.add(list);
            return;
        }
        list.add(root.val);
        List<Integer>left=new ArrayList<>(list);
        dfs(root.left,sum,currentsum+root.val,left);
        List<Integer>right=new ArrayList<>(list);
        dfs(root.right,sum,currentsum+root.val,right);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        if(root==null)
            return new ArrayList<>();
        ans=new ArrayList<>();
        dfs(root,sum,0,new ArrayList<>());        
        return ans;
        
    }
}