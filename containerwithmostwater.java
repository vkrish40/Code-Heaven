class Solution {
    public int maxArea(int[] height) {
        
        if(height==null || height.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int start=0;
        int end=height.length-1;
        
        while(start<end)
        {
            int val=Math.min(height[start],height[end]) * (end-start);
            max=max>val?max:val;
            if(height[start]>height[end])
                end--;
            else if(height[start]<height[end])//could have been simply else statement with start++
                start++;
            else if(height[start]==height[end])//Not required but I did it because if the values are same, then we can 
            {                                  //only anticipate a bigger area by changing both the start and the end.
                start++;
                end--;
            }
        }        
        return max;
        
    }
}