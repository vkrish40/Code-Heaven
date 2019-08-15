class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums.length==0)
            return new int[0];
        if(k==1)
            return nums;
        
        int[] ans=new int[(nums.length-k)+1];
        
        int high=nums[0];
        int pos=0;
        int temp=1;
        int counter=0;
        
        for(int i=1;i<nums.length;i++)
        {
            temp++;
            if(pos<=i-k)
            {
                pos++;
                high=nums[pos];
                i=pos;
                temp=1;
                continue;
            }
            if(nums[i]>high)
            {
                high=nums[i];
                pos=i;
            }
            if(temp==k)
            {
                ans[counter]=high;
                counter++;
                temp--;
            }            
        }
        
        return ans;
    }
}