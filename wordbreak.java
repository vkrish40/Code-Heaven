class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] ans=new boolean[s.length()+1];
        
        ans[0]=true;
        
        //Set<String> set=new HashSet<>(wordDict);
        
        for(int len=1;len<=s.length();len++)
        {
            for(int i=0;i<len;i++)
            {
                if(ans[i] && wordDict.contains(s.substring(i,len)))
                {
                    ans[len]=true;
                    break;
                }
            }
        }
        
        return ans[s.length()];
        
    }
}