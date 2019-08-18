class Solution {
    public int superEggDrop(int K, int N) {
        
        if(K==0 || N==0)
            return 0;
        int[][] drops=new int[K+1][N+1];
        
        for(int i=1;i<drops[0].length;i++)
            drops[1][i]=i;
        for(int i=2;i<drops.length;i++)
            drops[i][1]=1;
        for(int i=2;i<drops.length;i++)
        {
            for(int j=2;j<drops[0].length;j++)
            {
                int start=1;
                int min=Integer.MAX_VALUE;
                while(start<=j)
                {
                    int temp=1+Math.max(drops[i-1][start-1],drops[i][j-start]);
                    min=min>temp?temp:min;
                    start++;
                }
                drops[i][j]=min;
            }
        }
        
        return drops[K][N];
        
    }
}

/*Leads to a time limit exceeded error on the leetcode but need not worry. This's a good solution whose time complexity is almost cubic in the sense

that it takes O((total floor)squared times (total eggs))

There exists better solutions but they are extremely complex.*/