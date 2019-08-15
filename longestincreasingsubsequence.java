class Solution {
    public int lengthOfLIS(int[] nums) {
        /*DYNAMIC PROGRAMMING APPROACH ACHIEVES O(n squared)*/
        
        /*if(nums==null || nums.length==0)
            return 0;
        int ans[]=new int[nums.length];
        
        int len=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
            ans[i]=1;
        
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                    if(ans[i]<ans[j]+1) //Reason for this step: try this example: 10, 11, 5, 12
                        ans[i]=ans[j]+1;
            }
        }
        
        for(int i=0;i<ans.length;i++)
        {
           if(ans[i]>len)
               len=ans[i];
        }
        return len;*/
        
        /* O(n log n) approach using binary search */
        
        if(nums==null || nums.length==0)
            return 0;        
        int[] arr=new int[nums.length];
        arr[0]=nums[0];
        int last=0;
        for(int i=1;i<nums.length;i++)
        {
            if(arr[last]<nums[i])
            {
                last++;
                arr[last]=nums[i];
            }
            else if(arr[last]>nums[i])
            {
                int low=0;
                int high=last;
                int mid=0;
                while(low<=high)
                {
                    mid = (low+high)/2;
                    if(arr[mid]>nums[i])
                        high=mid-1;
                    else if(arr[mid]<nums[i])
                        low=mid+1;
                    else
                    {
                        low=mid;
                        break;
                    }
                }
                arr[low]=nums[i];
            }
        }
        
        for(int i=0;i<last+1;i++)
            System.out.print(arr[i]+" ");
        
        return last+1;
    }
}