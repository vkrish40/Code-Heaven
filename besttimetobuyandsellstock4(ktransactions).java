class Solution {
    public int maxProfit(int k, int[] prices) {
        
        /*Cubic time complexity - O(days squared times transactions), passes 209/211 test cases on leetcode before running into memory limit exceeded*/
        
        if(prices.length==0 || prices.length==1)
            return 0;
        
        int[][] profit=new int[k+1][prices.length];
        
        for(int i=1;i<profit.length;i++)
        {
            for(int j=1;j<prices.length;j++)
            {
                profit[i][j]=profit[i][j-1];
                int start=0;
                while(start<j)
                {
                    int val=prices[j]-prices[start]+profit[i-1][start];
                    profit[i][j]=Math.max(profit[i][j],val);
                    start++;
                }
            }
        }  
        
        return profit[k][prices.length-1];
    }
}

/*Alternate approach*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        
        /*Squared time complexity - O(days times transactions)* but still runs into memory limit exceeded error on the leetcode and manages to pass 209/211 test cases*/
        
        if(prices.length==0 || prices.length==1)
            return 0;
        
        int[][] profit=new int[k+1][prices.length];
        
        for(int i=1;i<profit.length;i++)
        {
            int maxdiff=profit[i-1][0]-prices[0];
            for(int j=1;j<prices.length;j++)
            {
                profit[i][j]=profit[i][j-1];
                maxdiff=Math.max(maxdiff,profit[i-1][j-1]-prices[j-1]);
                profit[i][j]=Math.max(profit[i][j],prices[j]+maxdiff);
            }
        }  
        
        return profit[k][prices.length-1];
    }
}