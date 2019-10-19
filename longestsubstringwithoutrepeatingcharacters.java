class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        
        Set<Character> set=new HashSet<>();
        
        int left=0, right=0;
        int max = Integer.MIN_VALUE;
        while(left<s.length() && right<s.length())
        {
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right));
                right++;
            }
            else
            {
                max=max>(right-left)?max:right-left;
                set.remove(s.charAt(left));
                left++;
            }
        }
        max=max>(right-left)?max:right-left;
        
        return max;
        
        
    }
}