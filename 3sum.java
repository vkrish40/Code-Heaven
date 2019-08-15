class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        int low,high,sum;
        List<List<Integer>> list=new ArrayList<>();
        if(nums==null || nums.length<3)
            return list;
        
        for(int i=0;i<nums.length-2;i++)
        {
            if(nums[i]>0)
                return list;
            low=i+1;
            high=nums.length-1;
            while(low<high)
            {            
                sum=nums[i]+nums[low]+nums[high];
                if(sum==0)
                {
                    list.add(Arrays.asList(nums[i],nums[low],nums[high]));
                }
                if(sum<=0)
                {
                    while((low+1)<high && nums[low]==nums[low+1])
                    {
                        low++;
                    }
                    low++;
                }
                if(sum>=0)
                {
                    while(low<(high-1) && nums[high]==nums[high-1])
                    {
                        high--;
                    }
                    high--;
                }
            }
            while(i+1<nums.length-2 && nums[i]==nums[i+1])
            {
                i++;
            }
        }
        return list;
        
    }
}