class Solution {
    int ans=0;
    public int minDistance(String word1, String word2) {
        
        /*        https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/editDistance.java
        
        int len1=word1.length()-1;
        int len2=word2.length()-1;
        
        if(len1==-1)
            return word2.length();
        if(len2==-1)
            return word1.length();
        
        if(word1.charAt(len1)==word2.charAt(len2))
        {
            ans=minDistance(word1.substring(0,len1),word2.substring(0,len2));
            return ans;
        }
                ans=1+Math.min(minDistance(word1.substring(0,len1),word2.substring(0,len2)),Math.min(minDistance(word1.substring(0,len1+1),word2.substring(0,len2)),minDistance(word1.substring(0,len1),word2.substring(0,len2+1))));
        
        return ans;*/
        int flag=0;
        int[][] min_distance= new int[word2.length()+1][word1.length()+1];
        for(int i=0;i<min_distance[0].length;i++)
            min_distance[0][i]=flag++;
        flag=0;
        for(int i=0;i<min_distance.length;i++)
            min_distance[i][0]=flag++;
        for(int i=1;i<min_distance.length;i++)
        {
            for(int j=1;j<min_distance[i].length;j++)
            {
                if(word1.charAt(j-1)==word2.charAt(i-1))
                    min_distance[i][j]=min_distance[i-1][j-1];
                else
                {
                    min_distance[i][j]=1+Math.min(min_distance[i-1][j-1], Math.min(min_distance[i-1][j],min_distance[i][j-1]));
                }                
            }
        }
        return min_distance[word2.length()][word1.length()];
        
    }
}