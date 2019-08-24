class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int incl=nums[0];
        int excl=0;
        for(int i=1;i<nums.length;i++)
        {
            int temp=incl;
            incl=Math.max(incl,excl+nums[i]);
            excl=temp;
        }
        
        return incl;
    }
}