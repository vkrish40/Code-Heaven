class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length==0 || prices.length==1)
            return 0;
        
        int[][] profit=new int[3][prices.length];
            
        for(int i=1;i<3;i++)
        {
            int maxdiff=profit[i-1][0]-prices[0];            
            for(int j=1;j<prices.length;j++)
            {
                profit[i][j]=profit[i][j-1];
                maxdiff=Math.max(maxdiff,profit[i-1][j-1]-prices[j-1]);
                profit[i][j]=Math.max(profit[i][j],prices[j]+maxdiff);
            }
        }
        
        return profit[2][prices.length-1];
        
    }
}