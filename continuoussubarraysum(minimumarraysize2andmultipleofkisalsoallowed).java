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
            currsum+=nums[i];
            
            if(i!=0 && k!=0 && currsum%k==0)
                return true;
            
            if(!map.containsKey(currsum))
                map.put(currsum,i); 
            
            if(i+1<nums.length && nums[i]==0 && nums[i+1]==0)
            {
               return true; 
            }
            
            int temp = currsum-k;
            
            while(temp>=0 && k!=0)
            {
                if(map.containsKey(temp) && (i-(map.get(temp)) > 1))
                    return true;
                temp=temp-k;
            }            
        }
        
        return false;
    }
}