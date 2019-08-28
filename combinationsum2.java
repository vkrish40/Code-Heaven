class Solution {
    
    public void find_combinations(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> ans)
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
                find_combinations(candidates, target-candidates[i], i+1, current, ans);
                current.remove(current.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        find_combinations(candidates, target, 0, new ArrayList<>(), ans);
        
        return ans;      
    }
}


/*

Approach using boolean way (Pretty long and inefficient solution)


class Solution {
    
        List<List<Integer>> full_list=new ArrayList<>();
    
        public void diff_subsets(boolean[][] ans, int[] candidates, int sum, int i, List<Integer> list)
        {
            if(sum==0)
            {
                Collections.sort(list);
                if(!full_list.contains(list))
                    full_list.add(list);
                return;
            }
            
            if(i==0 && ans[i][sum])
            {
                list.add(candidates[i]);
                Collections.sort(list);
                if(!full_list.contains(list))
                    full_list.add(list);
                return;
            }
            
            if(ans[i-1][sum])
            {
                List<Integer> temp=new ArrayList<>(list);
                diff_subsets(ans,candidates,sum,i-1,temp);
            }
            if(sum>=candidates[i] && ans[i-1][sum-candidates[i]])
            {
                list.add(candidates[i]);
                diff_subsets(ans,candidates,sum-candidates[i],i-1,list);
            }                
                
        }
    
        public void subsetsum(int[] candidates, int target)
        {
            boolean[][] ans=new boolean[candidates.length][target+1];
            for(int i=0;i<candidates.length;i++)
                ans[i][0]=true;
            for(int i=0;i<=target;i++)
            {
                if(candidates[0]==i)
                {
                    ans[0][i]=true;
                    break;
                }
            }
            for(int i=1;i<candidates.length;i++)
            {
                for(int j=1;j<=target;j++)
                {
                    if(candidates[i]>j)
                        ans[i][j]=ans[i-1][j];
                    else if(ans[i-1][j] || ans[i-1][j-candidates[i]])
                        ans[i][j]=true;
                }
            }
            
            if(ans[candidates.length-1][target])
                diff_subsets(ans, candidates, target, candidates.length-1, new ArrayList<>());
            else
                return;
        }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        subsetsum(candidates, target);
        
        return full_list;
        
    }
}*/