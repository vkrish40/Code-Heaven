class Solution {
    public int trap(int[] height) {
        
        int len=height.length;
        
        int left[]=new int[len];
        int right[]=new int[len];
        
        int total_water=0;
        
        if(height==null || height.length==0)
            return total_water;
        
        left[0]=height[0];
        right[len-1]=height[len-1];
        
        for(int i=1;i<len;i++)
        {
            left[i]=Math.max(left[i-1],height[i]);
        }
        for(int i=len-2;i>=0;i--)
        {
            right[i]=Math.max(right[i+1],height[i]);
        }
        
        for(int i=0;i<len;i++)
        {
            total_water=total_water+(Math.min(left[i],right[i]) - height[i]);
        }
        
        return total_water;
        
    }
}