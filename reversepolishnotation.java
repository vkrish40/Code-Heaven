class Solution {
    public int evalRPN(String[] tokens) {
        
        if(tokens==null || tokens.length==0)
            return 0;
        Deque<Integer> stack=new ArrayDeque<>();
        
        for(int i=0;i<tokens.length;i++)
        {
            if((tokens[i].length()>1 && Character.isDigit(tokens[i].charAt(1))) || Character.isDigit(tokens[i].charAt(0)))
                stack.push(Integer.valueOf(tokens[i]));
            else
            {
                int num2=stack.pop();
                int num1=stack.pop();
                int result=0;
                if(tokens[i].equals("+"))
                    result=num1+num2;
                else if(tokens[i].equals("-"))
                    result=num1-num2;
                else if(tokens[i].equals("*"))
                    result=num1*num2;
                else if(tokens[i].equals("/"))
                    result=num1/num2;
                stack.push(result);                
            }
        }
        
        return stack.pop();
        
    }
}