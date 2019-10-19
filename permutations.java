class Solution {
    
    List<List<Integer>> ans;
    Set<Integer> visited;
    
    public void permutation(int[] nums, List<Integer> list, int pos)
    {
        if(pos>=nums.length)
        {
            ans.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!visited.contains(i))
            {
                visited.add(i);
                list.add(nums[i]);
                permutation(nums, list, pos+1);
                visited.remove(i);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        ans = new ArrayList<>();
        
        visited = new HashSet<>();
        
        permutation(nums, new LinkedList<>(), 0);
        
        return ans;
        
    }
}