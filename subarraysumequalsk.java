class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if(nums==null || nums.length==0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currsum = 0;
        for(int i=0;i<nums.length;i++)
        {
            currsum+=nums[i];
            if(currsum==k)
                count++;
            if(map.containsKey(currsum-k))
                count+=map.get(currsum-k);
            map.put(currsum,map.getOrDefault(currsum,0)+1);
        }
        
        return count;
    }
}