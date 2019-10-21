class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        if(nums==null || nums.length==0)
            return false;
       
        if(k<0)
            k=Math.abs(k);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int currsum = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(i+1<nums.length && nums[i]==0 && nums[i+1]==0) // checking for the case in which two continuous 0 elements are
            {                                                 // there which means sum is 0, and 0 is a multiple of every 
               return true;                                   // number
            }
            
            currsum+=nums[i];
            
            if(i!=0 && k!=0 && currsum%k==0)    // checking if the total sum accumulated till now is a multiple of k,
                return true;                    //considering, k is not  0 and the length of the subarray is at least 2
            
            if(!map.containsKey(currsum))   //storing the total sum that can be obtained from the beginning index 
                map.put(currsum,i);         //to the current index  
            
            int temp = currsum-k;
            
            while(temp>=0 && k!=0)         //checking if the subarray sum is a multiple of k by continuously deleting k from 
            {                              //the currentsum and if he number obtained after deleting k from the currentsum is 
                if(map.containsKey(temp) && (i-(map.get(temp)) > 1)) //present inside the map and its location is at least 2
                    return true;                                     //away from current position, then we found the subarray
                temp=temp-k;                                        //sum being a multiple of k 
            }            
        }
        
        return false;
    }
}