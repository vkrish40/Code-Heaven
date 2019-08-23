class Solution {
    
    public int dp(int[] nums, int start, int end)
    {
        int incl=nums[start];
        int excl=0;
        
        for(int i=start+1;i<end;i++)
        {
            int temp=incl;
            incl=Math.max(incl,excl+nums[i]);
            excl=temp;
        }
        
        return incl;
        
    }
    
    
    public int rob(int[] nums) {
        
        if(nums.length==0)
            return 0;        
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        
        return Math.max(dp(nums,0,nums.length-1),dp(nums,1,nums.length));
        
    }
}