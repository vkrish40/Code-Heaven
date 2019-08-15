class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] store=new int[nums.length];
        int prod=1;
        
        for(int i=0;i<nums.length;i++)
        {
            store[i]=prod;
            prod=prod*nums[i];            
        }
        
        prod=1;
        
        for(int i=nums.length-1;i>=0;i--)
        {
            store[i]=store[i]*prod;
            prod=prod*nums[i];            
        }
        
        return store;
        
        
    }
}