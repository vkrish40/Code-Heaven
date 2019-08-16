class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums);
        return nums[(nums.length-k)];
    }
}

/*This can be done in almost linear time as well using quicksort approach (not exactly complete quicksort).
   You'll understand what I am trying to say if you refer this video: 
   https://www.youtube.com/watch?v=hGK_5n81drs
*/
