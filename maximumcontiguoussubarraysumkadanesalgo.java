class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length==0)
            return 0;
        int high=nums[0];
        int temp=0;
        
        for(int i=1;i<nums.length;i++)
        {
            temp=nums[i]+nums[i-1];
            nums[i]=nums[i]>temp?nums[i]:temp;
            high=high>nums[i]?high:nums[i];
        }
        return high;
        
    }
}
/*Kadane's algorithm*/