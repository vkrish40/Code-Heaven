class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int low,high,sum;
        if(nums==null || nums.length<4)
            return list;
        
        for(int i=0;i<nums.length-3;i++)
        {
            /*if(target<0)
                if(nums[i]>=0)
                    return list;
            else if (target>=0 && nums[i]>target)
                return list;*/ //not needed, doesn't help with both the complexities much
                
            for(int j=i+1;j<nums.length-2;j++)
            {
                low=j+1;
                high=nums.length-1;
                while(low<high)
                {
                    sum=nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum==target)
                    {
                        list.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                    }
                    if(sum<=target)
                    {
                        while((low+1)<high && nums[low]==nums[low+1])
                        {
                            low++;
                        }
                        low++;
                    }
                    if(sum>=target)
                    {
                        while(low<(high-1) && nums[high]==nums[high-1])
                        {
                            high--;
                        }
                        high--;
                    }
                }
                while((j+1)<nums.length-2 && nums[j]==nums[j+1])
                {
                    j++;
                }
            }
            while((i+1)<nums.length-3 && nums[i]==nums[i+1])
            {
                i++;
            }
        }
        return list;
    }
}


/* Alternate solution
	passes 281/282 test cases, gives runtime error for the 282nd test case 


class Solution {
    
    public void find_combinations(int[] nums, int target,int currsum, int index, List<Integer> current, List<List<Integer>> ans, int count)
    {
        if(currsum==target && count==4)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        else if(count==4)
        {
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            if((i==index || nums[i]!=nums[i-1]) && (4-count)<=nums.length-i)
            {
                current.add(nums[i]);
                find_combinations(nums, target, currsum+nums[i], i+1, current, ans, count+1);
                current.remove(current.size()-1);
            }
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        find_combinations(nums, target, 0, 0, new ArrayList<>(), ans, 0);
        
        return ans;
    }
}

*/
