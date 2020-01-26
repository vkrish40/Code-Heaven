class Solution {
    public boolean isMatch(String s, String p) {
        
        if(s.length()==0 && p.length()==0)
            return true;
        else if(p.length()==0)
            return false;
        StringBuffer pattern = new StringBuffer();
        pattern.append(p.charAt(0));
        for(int i=0;i<p.length()-1;i++)
        {
            if(p.charAt(i)=='*' && p.charAt(i+1)=='*')
                continue;
            pattern.append(p.charAt(i+1));
        }
        boolean[][] dp = new boolean[s.length()+1][pattern.length()+1];
        dp[0][0] = true;
        for(int i=1;i<=pattern.length();i++)
        {
            if(i==1 && pattern.charAt(i-1)=='*')
                dp[0][i]=true;
            else if(pattern.charAt(i-1)=='*')
                dp[0][i]=dp[0][i-2];
        }
        
        for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=pattern.length();j++)
            {
                if(s.charAt(i-1)==pattern.charAt(j-1) || pattern.charAt(j-1)=='.')
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern.charAt(j-1)=='*')
                {
                    dp[i][j] = dp[i][j-2];
                    if(s.charAt(i-1)==pattern.charAt(j-2) || pattern.charAt(j-2)=='.')
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                else
                    dp[i][j] = false;
            }
        }
        
        return dp[s.length()][pattern.length()];
    }
}