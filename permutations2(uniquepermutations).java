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
        int temp = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(temp==nums[i])
                continue;
            if(!visited.contains(i))
            {
                temp = nums[i];
                visited.add(i);
                list.add(nums[i]);
                permutation(nums, list, pos+1);
                visited.remove(i);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        ans = new ArrayList<>();
        
        visited = new HashSet<>();
        
        Arrays.sort(nums);
        
        permutation(nums, new LinkedList<>(), 0);
        
        System.out.println(ans.size());
    
        return ans;
        
    }
}