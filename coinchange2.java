class Solution {
    public int change(int amount, int[] coins) {
        
        if(coins.length==0 && amount!=0)
            return 0;
        if(amount==0)
            return 1;
        
        int[][] ans=new int[coins.length+1][amount+1];
        
        //for(int i=0;i<ans.length;i++)
            //ans[i][0]=1;
        ans[0][0]=1;
        
        for(int i=1;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                if(coins[i-1]>j)
                    ans[i][j]=ans[i-1][j];
                else
                    ans[i][j]=ans[i-1][j]+ans[i][j-coins[i-1]];
            }
        }
        
        return ans[coins.length][amount];
        
    }
}