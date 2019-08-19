class Solution {
    
    List<String> list;
    
    public void parentheses(int left, int right, String soln)
    {
        if(left==0)
        {
            for(int i=1;i<=right;i++)
                soln+=")";
            list.add(soln);
        }
        else if(left==right)
            parentheses(left-1,right,soln+"(");
        else if(left<right)
        {
            parentheses(left-1,right,soln+"(");
            parentheses(left,right-1,soln+")");
        }
    }
    
    
    public List<String> generateParenthesis(int n) {
        
        if(n==0)
            return new ArrayList<>();
        list=new ArrayList<>();
        parentheses(n,n,"");
        return list;
    }
}