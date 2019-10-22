class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        /*O(log(minLength(nums1,nums2))) - time complexity*/
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int[] arr1 = len1>=len2?nums2:nums1;
        int[] arr2 = len1>=len2?nums1:nums2;
        
        int left=0;
        int right=arr1.length;
        int total_length = arr1.length+arr2.length;
        
        double median = 0.0;
        
        
        while(left<=right)
        {
            int first_left = (left+right)/2;
            int second_left = ((total_length+1)/2)-first_left;
            int x_left = (first_left-1)>=0?arr1[first_left-1]:Integer.MIN_VALUE;
            int x_right = ((first_left)>=0) && (first_left<arr1.length)?arr1[first_left]:Integer.MAX_VALUE;
            
            int y_left = (second_left-1)>=0?arr2[second_left-1]:Integer.MIN_VALUE;
            int y_right = ((second_left)>=0) && (second_left<arr2.length)?arr2[second_left]:Integer.MAX_VALUE;
            
            if(x_left<=y_right && x_right>=y_left)
            {
                if(total_length%2==0)
                    median = (Math.max(x_left,y_left)+Math.min(x_right,y_right))/2.0;
                else
                    median = Math.max(x_left,y_left);
                break;
            }
            else if(x_left>y_right)
                right=first_left-1;
            else
                left=first_left+1;
        }
        
        return median;
    }
}