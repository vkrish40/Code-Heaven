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
    
    public void dfs(TreeNode root, int target, int current_sum, List<Integer> list)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null && current_sum+root.val == target)
        {
            list.add(root.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        
        list.add(root.val);
        dfs(root.left, target, current_sum+root.val, list);      
        dfs(root.right, target, current_sum+root.val, list);    
        list.remove(list.size()-1);        
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        if(root==null)
            return Arrays.asList();
        ans = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>());
        
        return ans;
        
    }
}