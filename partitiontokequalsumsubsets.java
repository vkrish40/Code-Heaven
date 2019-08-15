class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum=sum+nums[i];
        if(sum==0 || sum%k!=0)
            return false;
        int target=sum/k;
        return canPartition(0, nums, new boolean[nums.length], 0, target, k);        
    }
    public boolean canPartition(int start, int[] arr, boolean[] used, int currentsum, int target, int parts)
    {
        if(parts==1)
            return true;
        if(currentsum==target)
        {
            return canPartition(0, arr, used, 0, target, parts-1);   
        }
        if(currentsum>target)
        {
            return false;
        }
        for(int i=start;i<arr.length;i++)
        {
            if(used[i]!=true)
            {
                used[i]=true;
                if(canPartition(i+1, arr, used, currentsum+arr[i], target, parts))
                    return true;
                used[i]=false; 
            }
        }
        return false;
    }
}