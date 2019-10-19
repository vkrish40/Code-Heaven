class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length==0)
            return "";
        
        int index = 0;
        
        StringBuilder strb = new StringBuilder();
        
        while(index<strs[0].length())
        {
            char ch = strs[0].charAt(index);
            for(int i=1;i<strs.length;i++)
            {
                if(index>=strs[i].length() || strs[i].charAt(index)!=ch)
                    return new String(strb);                
            }
            strb.append(ch);
            index++;
        }
        
        return new String(strb);
        
    }
}