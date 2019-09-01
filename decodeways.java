class Solution {
    public int numDecodings(String s) {
        
        if(s.length()==0 || s==null)
            return 0;
        if(s.charAt(0)=='0')
            return 0;
        int[] ans=new int[s.length()+1];
        ans[0]=1;
        ans[1]=1;
        for(int i=2;i<=s.length();i++)
        {
            int singledigit=Integer.parseInt(s.substring(i-1,i));
            int doubledigit=Integer.parseInt(s.substring(i-2,i));
            
            if(singledigit>0)
            {
                ans[i]=ans[i-1];
            }
            if(doubledigit>=10 && doubledigit<=26)
            {
                ans[i]+=ans[i-2];
            }
            
        }       
        
        return ans[s.length()];
    
        
    }
}