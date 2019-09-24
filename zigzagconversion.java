class Solution {
    public String convert(String s, int numRows) {
        
        if(s==null || s.length()==0)
            return "";
        else if(numRows==1 || numRows>=s.length())
            return s;
        
        StringBuilder[] str=new StringBuilder[numRows];
        String ans="";
        
        for(int i=0;i<str.length;i++)
            str[i]=new StringBuilder();
        
        StringBuilder temp;
        
        String dir="down";
        
        int index=0;
        int count=0;
        while(index<s.length())
        {
            if(count==0)
                dir="down";
            else if(count==numRows-1)
                dir="up";
            temp=str[count];
            temp.append(s.charAt(index));
            index++;
            if(dir.equals("down"))
                count++;
            else if(dir.equals("up"))
                count--;            
        }
        for(int i=0;i<str.length;i++)
            ans+=str[i].toString();
        
        return ans;
    }
}