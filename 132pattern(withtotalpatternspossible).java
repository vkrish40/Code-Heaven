class Solution {
    public boolean find132pattern(int[] nums) {
        
        if(nums==null || nums.length<3)
            return false;
        
        int[] dp = new int[nums.length];
        
        int total = 0;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i]++;
                }
                else if(dp[i]>=1 && nums[j]>nums[i])
                {
                    total +=dp[i];
                }
            }
        }
        
        System.out.println("Total Patterns: " + total);
        
        if(total > 0)
            return true;
        return false;
        
    }
}