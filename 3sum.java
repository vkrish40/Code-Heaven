class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        Arrays.sort(nums);
        int left,right,sum;
        for(int i=0;i<nums.length-2;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            left=i+1;
            right=nums.length-1;                        
            while(left<right)
            {
                int prev_left = nums[left];
                int prev_right = nums[right];
                sum=nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==prev_left && nums[right]==prev_right)
                    {
                        left++;
                        right--;
                    } 
                }
                else if(sum<0)
                    left++;
                else
                    right--;                
            }
        }
        
        return ans;
    }
}