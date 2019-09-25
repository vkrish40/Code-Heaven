class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0)
            return 0;
        int[][] dp=new int[s.length()][s.length()];
        
        for(int i=0;i<dp.length;i++)
            dp[i][i]=1;
        for(int i=0;i<dp.length-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                dp[i][i+1]=2;
            else
                dp[i][i+1]=1;
        }
        for(int i=3;i<=s.length();i++)
        {
            for(int j=0;j<=s.length()-i;j++)
            {
                int end=j+i-1;
                if(s.charAt(j)==s.charAt(end))
                    dp[j][end]=2+dp[j+1][end-1];
                else
                    dp[j][end]=Math.max(dp[j][end-1],dp[j+1][end]);
            }
        }

        return dp[0][s.length()-1];
    }
}