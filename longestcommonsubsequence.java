class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        /*  LOGIC
        
        if(text1.length()==0 || text2.length()==0)
            return 0;
        
        int len1=text1.length();
        int len2=text2.length();
        String temp1=text1.substring(0,len1-1);
        String temp2=text2.substring(0,len2-1);
        
        if(text1.charAt(len1-1) == text2.charAt(len2-1))
            return 1+longestCommonSubsequence(temp1,temp2);
        else
            return Math.max(longestCommonSubsequence(temp1,text2),longestCommonSubsequence(text1,temp2));*/
        
        int ans[][]=new int[text1.length()+1][text2.length()+1];
        
        for(int i=1;i<ans.length;i++)
        {
            for(int j=1;j<ans[0].length;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    ans[i][j]=1+ans[i-1][j-1];
                else
                    ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
            }
        }
        return ans[text1.length()][text2.length()];
    }
}