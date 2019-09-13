class Solution {
    public int minIncrementForUnique(int[] A) {
        
        if(A==null || A.length==0)
            return 0;
        
        Arrays.sort(A);
        
        int num = A[0];
        int moves=0;
        
        for(int i=1;i<A.length;i++)
        {
            if(A[i]==A[i-1])
            {
                if(num<=A[i])
                    num=A[i]+1;               
                
                for(int j=i+1;j<A.length;j++)
                {
                    if(A[j]!=num)
                        continue;
                    num++;
                }
                moves+=num-A[i];
                num++;
            }
        }        
       return moves;
        
    }
}