class Solution {
    public int minPathSum(int[][] grid) {
        
        if(grid==null || grid.length==0)
            return 0;
        
        int[][] dp=new int[grid.length][grid[0].length];
        
        for(int i=0;i<dp[0].length;i++)
        {
            if(i==0)
                dp[0][0]=grid[0][0];
            else
                dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        
        for(int i=1;i<grid.length;i++)
        {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
    }
}