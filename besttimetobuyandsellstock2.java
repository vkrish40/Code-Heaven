class Solution {
    public int maxProfit(int[] prices) {
        
        int profit=0;
        if(prices.length==0)
            return profit;
        int lowest=prices[0];
        int highest=prices[0];
        
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<lowest)
            {
                lowest=prices[i];
                highest=prices[i];
            }
            if(prices[i]>highest)
            {
                highest=prices[i];
                profit=profit+(highest-lowest);
                lowest=highest;
            }
        }
        return profit;
        
    }
}