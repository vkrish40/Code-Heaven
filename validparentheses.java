class Solution {
    public boolean isValid(String s) {
        
        if(s.length()==0)
            return true;
        if(s==null || s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']')
            return false;      

        Deque<Character> stack=new ArrayDeque<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++)
        {
            char ch=' ';
            if(!stack.isEmpty())
            {
                ch=stack.peek();  
            }
            if(s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']')
            {
                if(ch==' ' || map.get(ch)!=s.charAt(i))
                    return false;
                stack.pop();              
            }
            else
            {
                stack.push(s.charAt(i));
            }            
        }
        
        if(stack.isEmpty())
            return true;
        else 
            return false;
    }
}