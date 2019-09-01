/*

Bottom up approach (linear time complexity)

*/


class Solution {
    public int numDecodings(String s) {
        
        if(s.length()==0 || s==null || s.charAt(0)=='0')
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

/*

Top down approach with memoization which reduces exponential run time to linear time. 

*/


class Solution {
    
    Map<Integer,Integer> map;
    
    public int topdown(String word,int i)
    {
        if(map.containsKey(i))
            return map.get(i);
        if(word.length()==i)
            return 1;
        if(word.charAt(i)=='0')
            return 0;
        int val1=topdown(word,i+1);
        int val2=0;
        if(i+2<=word.length())
        {
            int temp=Integer.parseInt(word.substring(i,i+2));
            if(temp>=10 && temp<=26)
                val2=topdown(word,i+2);
        }
        map.put(i,val1+val2);
        return val1+val2;
    }
    
    public int numDecodings(String s) { 
        
        map=new HashMap<>();
        
        return topdown(s,0);
        
    }
}