class Solution {
    public int longestOnes(int[] A, int K) {
        
        int left = 0;
        int right = 0;
        int len = 0;
        int zeroes = 0;
        
        while(right<A.length)
        {
            if(A[right]==1)
            {
                right++;
                continue;
            }
            else if(zeroes<K)
            {
                zeroes++;
                right++;
            }
            else
            {
                len = right-left>len?right-left:len;
                
                if(A[left]==0)
                    zeroes--;
                left++;
                /*
                Alternate approach for understanding purpose
                
                if(zeroes==0)
                {
                    right++;
                    left=right-1;
                }
                if(zeroes!=0 && A[left]==0)
                {
                    zeroes--;
                }
                left++;*/
            }            
        }
        
        len = right-left>len?right-left:len;
        return len;
    }
}