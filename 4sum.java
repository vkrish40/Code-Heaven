class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        Arrays.sort(nums);
        
        int left,right,sum;
        
        for(int i=0;i<nums.length-3;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                left=j+1;
                right=nums.length-1;
                while(left<right)
                {
                    int prev_left = nums[left];
                    int prev_right = nums[right];
                    sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target)
                    {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==prev_left && nums[right]==prev_right)
                        {
                            left++;
                            right--;
                        }
                    }
                    else if(sum<target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }
        
        return ans;
        
    }
}