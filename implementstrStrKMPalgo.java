class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;
        
        int[] track = new int[needle.length()];
        
        int i=0;
        int j=1;
        track[0]=0;
        
        while(j<needle.length())
        {
            if(needle.charAt(i)==needle.charAt(j))
            {
                i++;
                track[j]=i;
                j++;
            }
            else if(i==0)
            {
                track[j]=0;
                j++;
            }
            else
            {
                i=track[i-1];
            }
        }
        
        i=0;
        j=0;
        while(j<haystack.length())
        {
            if(haystack.charAt(j)==needle.charAt(i))
            {
                if(i==needle.length()-1)
                    return j-i;
                j++;
                i++;
            }
            else if(i==0)
            {
                j++;
            }
            else
            {
                i=track[i-1];
            }
        }
        
        return -1;
    }
}