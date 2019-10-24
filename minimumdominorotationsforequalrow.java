class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        int[] top = new int[7];
        int[] bottom = new int[7];
        int[] same = new int[7];
        
        int len = A.length;
        
        for(int i=0;i<A.length;i++)
        {
            top[A[i]]++;
            bottom[B[i]]++;
            
            if(A[i]==B[i])
                same[A[i]]++;
        }
        
        for(int i=1;i<7;i++)
        {
            if(top[i]+bottom[i]-same[i]==len)
                return len-Math.max(top[i],bottom[i]);
        }
        
        return -1;
        
    }
}