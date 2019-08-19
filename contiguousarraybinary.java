class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return 0;
        int count = 0;
        int high=Integer.MIN_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
                count++;
            else if(nums[i]==0)
                count--;
            if(count==0)
                high=i+1;
            else if(map.containsKey(count))
                high=high>(i-map.get(count))?high:(i-map.get(count));
            else
                map.put(count,i);
        }
        
        if(high==Integer.MIN_VALUE)
            return 0;
        return high;
        
    }
}