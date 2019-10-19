class Solution {
    int left=Integer.MAX_VALUE;
    int right=Integer.MIN_VALUE;
    
    public void binarySearch(int[] nums, int target, int start, int end)
    {
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(nums[mid]>target)
            {
                end=mid-1;
            }
            else if(nums[mid]<target)
            {
                start=mid+1;
            }
            else
            {
                left=left<mid?left:mid;
                right=right>mid?right:mid;
                binarySearch(nums, target, start, mid-1);
                binarySearch(nums, target, mid+1, end);
                break;                
            }
        }
    }
    public int[] searchRange(int[] nums, int target) {
        
        if(nums==null||nums.length==0)
            return new int[]{-1,-1};
        
        binarySearch(nums, target, 0, nums.length-1);
        
        if(left==Integer.MAX_VALUE)// if left == Integer.MAX_VALUE then it's a guarantee that right == Integer.MIN_VALUE
            return new int[]{-1,-1};
        
        int[] ans = new int[2];
        ans[0]=left;
        ans[1]=right;
        
        return ans;
    }
}