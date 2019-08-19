class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Queue<List<String>> list=new LinkedList<>();
        
        List<List<String>> ans=new ArrayList<>();
        
        if(!wordList.contains(endWord))
            return ans;
        
        Iterator<String> itr;
        

        List<String> temp=new ArrayList<>();
        temp.add(beginWord);
        list.add(temp);
        int min=Integer.MAX_VALUE;
        int len;
        while(!list.isEmpty())
        {
            List<String> flag=list.poll();
            len=flag.size();
            if(len>min)
                break;
            if(flag.contains(endWord))
            {                
                ans.add(new ArrayList<>(flag));
                min=flag.size();
                continue;
            }
            else if(len==min)
                continue;
            String extra=flag.get(flag.size()-1);
            itr=wordList.iterator();
            while(itr.hasNext())
            {
                String comp=itr.next();
                if(flag.contains(comp))
                    continue;                
                int count=0;                
                for(int i=0;i<extra.length();i++)
                {
                    if(extra.charAt(i)!=comp.charAt(i))
                        count++;                    
                }
                if(count==1)
                {
                    flag.add(comp);
                    list.add(new ArrayList<>(flag));
                    flag.remove(comp);
                }
            }
        }
        
        return ans;
    }
}