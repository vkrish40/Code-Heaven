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

/*Alternate method*/

class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices==null || prices.length==0)
            return 0;
        
        int low = prices[0];
        int high = prices[0];
        int profit = 0;
        int count = 1;
        
        while(count<prices.length)
        {
            if(prices[count]>high)
            {
                high = prices[count];
            }
            else
            {
                profit+=high-low;
                low = prices[count];
                high = prices[count];
            }
            count++;
        }
        
        profit+=high-low;
        
        return profit;
        
    }
}