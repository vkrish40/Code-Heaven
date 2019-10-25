class Solution {
    public int jump(int[] nums) {
        
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0]=0;
        
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(j+nums[j]>=i && jumps[i]>jumps[j]+1)
                {
                    jumps[i]=jumps[j]+1;
                }
            }
        }        
        return jumps[jumps.length-1];
        
    }
}