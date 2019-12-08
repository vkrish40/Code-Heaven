class Solution {
    public int minSwap(int[] A, int[] B) {
        
        int no_swap = 0;
        int swap = 1;
        
        for(int i=1;i<A.length;i++)
        {
            int ns = Integer.MAX_VALUE;
            int s = Integer.MAX_VALUE;
            
            if(A[i]>A[i-1] && B[i]>B[i-1])
            {
                ns = no_swap;
                s = swap+1;
            }
            
            if(A[i-1]<B[i] && B[i-1]<A[i])
            {
                ns = Math.min(ns,swap);
                s = no_swap+1;
            }
            
            no_swap = ns;
            swap = s;
        }
        
        return Math.min(no_swap, swap);
        
        
    }
}