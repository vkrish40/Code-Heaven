class Solution {
    
    boolean[][] dp;
    
    public void isPalindrome(String s)
    {
        for(int i=0;i<s.length();i++)
            dp[i][i] = true;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                dp[i][i+1] = true;
        }
        
        for(int i=2;i<s.length();i++)
        {
            for(int j=0;(j+i)<s.length();j++)
            {
                int pos = j+i;
                if(s.charAt(j)==s.charAt(pos) && dp[j+1][pos-1])
                {
                    dp[j][pos] = true;
                }
                else
                    dp[j][pos] = false;
            }
        }
    }
    
    public int minCut(String s) {
        
        dp = new boolean[s.length()][s.length()];
        
        isPalindrome(s);
        
        int[] minCut = new int[s.length()];
        
        Arrays.fill(minCut, Integer.MAX_VALUE);
        
        for(int i=0;i<s.length();i++)
        {
            if(dp[0][i])
                minCut[i] = 0;
            else
            {
                for(int j=0;j<i;j++)
                {
                    if(dp[j+1][i] && minCut[j]+1<minCut[i])
                        minCut[i] = minCut[j]+1;
                }
            }
        }
        
        return minCut[s.length()-1];
    }
}