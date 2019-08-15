class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> col = new HashMap<>(); 
        int max = 0,flag = 0,index;
        for(int i=0;i<s.length();i++)
        {
            if(col.containsKey(s.charAt(i)))
            {
                index=col.get(s.charAt(i));
                i=index;
                flag = flag<max?max:flag;
                max = 0;
                col.clear();
            }
            else
            {
                col.put(s.charAt(i),i);
                max++;
                if(i==s.length()-1)
                    flag = flag<max?max:flag;               
            }
        }
        return flag;
    }
}