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

/*Linear time approach using Deque though the above code runs faster on leetcode which has O(nK) time complexity */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums==null || nums.length<k || k==0)
            return new int[]{};
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        
        int count=0;
        int flag=0;
        for(int i=0;i<nums.length;i++)
        {
            count++;
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(count==k)
            {
                count--;
                while(!deque.isEmpty() && deque.peekFirst()<=i-k)
                {
                    deque.pollFirst();
                }
                ans[flag] = nums[deque.peekFirst()];
                flag++;                
            }
        }
        
        return ans;
        
    }
}