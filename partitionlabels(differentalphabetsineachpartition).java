class Solution {
    public List<Integer> partitionLabels(String S) {
        
        if(S.length()==0 || S==null)
            return new ArrayList<>();
        
        Map<Character, Integer> map=new HashMap<>();
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<S.length();i++)
        {
            map.put(S.charAt(i),i);
        }
        
        for(int i=0;i<S.length();i++)
        {
            int index=map.get(S.charAt(i));
            for(int j=i+1;j<index;j++)
            {
                int temp=map.get(S.charAt(j));
                index=index>temp?index:temp;
            }
            int val=index-i+1;
            ans.add(val);
            i=index;
        }
        
        return ans;
        
    }
}