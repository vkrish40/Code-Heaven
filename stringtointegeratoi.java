class Solution {
    public int myAtoi(String str) {
        
        str=str.trim();
        int a=1;
        int flag=0;
        double store=0;
        int ans=0;
        
        for(char ch:str.toCharArray())
        {
            if(a==1)
                ans=(int)(store>Integer.MAX_VALUE?Integer.MAX_VALUE:store);
            if(a==-1)
                ans=(int)(store<Integer.MIN_VALUE?Integer.MIN_VALUE:store);
            
            //if(Character.isLetter(ch) && flag==1)
                //return ans;
            //if(Character.isLetter(ch) && check==0)
               // return ans;
            if(ch=='+' && flag==0)
            {
                flag=1;
                a=1;
                continue;
            }
            if(ch=='-' && flag==0)
            {
                flag=1;
                a=-1;
                continue;
            }
            if((!Character.isDigit(ch) && flag==1) || (!Character.isDigit(ch) && flag==0))
                return ans;
            if(Character.isDigit(ch))
            {
                if(a==-1)
                    store = (store*10)-Integer.parseInt(""+ch);
                if(a==1)
                    store = (store*10)+Integer.parseInt(""+ch);
                flag=1;
            } 
        }
        if(a==1)
            ans=(int)(store>Integer.MAX_VALUE?Integer.MAX_VALUE:store);
        if(a==-1)
            ans=(int)(store<Integer.MIN_VALUE?Integer.MIN_VALUE:store);
            
        return ans;
    }
}