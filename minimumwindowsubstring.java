class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()==0 || t.length()==0)
            return "";
        int min_len=Integer.MAX_VALUE;
        String ans="";
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> build=new HashMap<>();
        
        for(int i=0;i<t.length();i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        
        int required=map.size();
        int matched=0;
        
        int l=0,r=0;
        
        while(r<s.length())
        {
            Character a=s.charAt(r);
            build.put(a,build.getOrDefault(a,0)+1);
            
            if(map.containsKey(a) && build.get(a)==map.get(a))
                matched++;
            
            while(l<=r && matched==required)
            {
                char ch=s.charAt(l);
                int len = r-l+1;
                if(len<min_len)
                {
                   min_len=len;
                   ans=s.substring(l,r+1);
                }
                 
                build.put(ch,build.get(ch)-1);
                    
                if(map.containsKey(ch) && map.get(ch)>build.get(ch))
                {
                    matched--;   
                }
                l++;
            }
            
            r++;
        }
        return ans;
        
    }
}

/*Another approach but time limit exceeded in one of the test cases

class Solution {
    
    public boolean compare(String pattern, String check)
    {
        Map<Character, Integer> map=new HashMap<>();
        
        for(int i=0;i<pattern.length();i++)
        {
            Character a=pattern.charAt(i);
            int val=map.getOrDefault(a,0);
            map.put(a, val+1);
        }
        for(int i=0;i<check.length();i++)
        {
            Character a=check.charAt(i);
            if(map.containsKey(a))
            {
                int val=map.get(a);
                val--;
                if(val==0)
                    map.remove(a);
                else
                    map.put(a,val);
            }
        }
        if(map.isEmpty())
            return true;
        else
            return false;
    }
    public String minWindow(String s, String t) {
        
        if(s.length()==0)
            return "";
        
       int min_len=Integer.MAX_VALUE;
       String ans="";
       int l=0;
        
       for(int r=0;r<s.length();r++)
       {
           String elm=s.substring(l,r+1);
                
           boolean check=compare(t,s.substring(l,r+1));
                
           if(check==true && elm.length()<min_len)
           {
               min_len=elm.length();
               if(min_len==1)
                   return elm;
               ans=elm;
               l++;
               r--;
            }
            else if((r-l+1)==min_len-1)
            {
                l++;
            }                
        }
        return ans;
        
    }
}

*/


