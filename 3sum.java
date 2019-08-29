class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        Arrays.sort(nums);
        int left,right,sum;
        for(int i=0;i<nums.length-2;i++)
        {
            left=i+1;
            right=nums.length-1;
            while(left<right)
            {
                sum=nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    if(!ans.contains(Arrays.asList(nums[i],nums[left],nums[right])))
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;                    
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