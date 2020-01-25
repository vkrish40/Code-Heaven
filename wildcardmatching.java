class Solution {
    public boolean isMatch(String s, String p) {
        
        if(s.length()==0 && p.length()==0)
            return true;
        else if(p.length()==0)
            return false;
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        dp[0][0] = true;
        for(int i=1;i<=p.length();i++) // for the case of multiple * in the pattern at the beginning
        {                               // example pattern = *****ho
            if(p.charAt(i-1)=='*')
                dp[0][i] = true;
            else
                break;            
        }
        for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=p.length();j++)
            {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                
                else if(p.charAt(j-1)=='*')
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                else
                    dp[i][j] = false;
            }
        }
        
        return dp[s.length()][p.length()];
        
    }
}