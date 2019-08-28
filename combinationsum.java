class Solution {
    
    public void find_combinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        else if (target<0)
        {
            return;
        }
        
        for(int i=index;i<candidates.length;i++)
        {
            if(i==index || candidates[i]!=candidates[i-1])
            {
                current.add(candidates[i]);
                find_combinations(candidates, i, target-candidates[i], current, ans);
                current.remove(current.size()-1);
            }
        }
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        find_combinations(candidates, 0, target, new ArrayList<>(), ans); 
        
        return ans;
    }
}