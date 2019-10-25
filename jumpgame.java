class Solution {
    public boolean canJump(int[] nums) {
        
        boolean[] jump = new boolean[nums.length];
        jump[0] = true;
        
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(j+nums[j]>=i && jump[j]==true)
                {
                    jump[i]=true;
                    break;
                }
            }
        }
        
        return jump[jump.length-1];
    }
}