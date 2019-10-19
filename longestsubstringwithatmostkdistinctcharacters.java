public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        
        if(s==null || s.length()==0 || k==0)
            return 0;
        if(s.length()==k)
            return k;
        
        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        
        Map<Character, Integer> map=new HashMap<>();
        
        while(right<s.length())
        {
            if(map.containsKey(s.charAt(right)))
            {
                int val = map.get(s.charAt(right));
                map.put(s.charAt(right),val+1);
                right++;
            }
            else if(map.size()<k)
            {
                map.put(s.charAt(right),1);
                right++;
            }
            else
            {
                max=max>(right-left)?max:(right-left);
                int temp = map.get(s.charAt(left))-1;
                if(temp==0)
                    map.remove(s.charAt(left));
                else
                    map.put(s.charAt(left),temp);
                left++;
            }
        }
        max=max>(right-left)?max:(right-left);
        
        return max;
    }
}