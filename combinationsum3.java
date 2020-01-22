class Solution {
    
    List<List<Integer>> ans;
    public void backtrack(List<Integer> list, int k, int n, int currentsum, int currentcount, int start)
    {
        if(currentcount==k && currentsum==n)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(currentcount>k)
            return;
        for(int i=start;i<=9;i++)
        {
            if(currentsum+i>n)
                return;
            list.add(i);
            backtrack(list, k, n, currentsum+i, currentcount+1, i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        ans = new ArrayList<>();
        
        backtrack(new ArrayList<>(), k, n, 0, 0, 1);
        
        return ans;
        
    }
}