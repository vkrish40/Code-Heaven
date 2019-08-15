class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        boolean state[][]=new boolean[len][len];
        
        int start=0;
        int max=1;
        int k;
        
        for(int i=0;i<len;i++)
            state[i][i]=true;
        for(int i=0;i<len-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                start = i;
                max = 2;
                state[i][i+1]=true;
            }                
        }                
        for(int i=3;i<=len;i++)
        {
            for(int j=0;j<=len-i;j++)
            {
                k=j+i-1;
                if(state[j+1][k-1] && s.charAt(j)==s.charAt(k))
                {
                    start = j;
                    max = i;
                    state[j][k]=true;
                }
            }
        }
              
        if(s.isEmpty())
            return "";
        
        return s.substring(start,start+max);
    }
}