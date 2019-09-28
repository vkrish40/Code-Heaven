class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord))
            return 0;
        //if(wordList.contains(beginWord)) //Not required since beginWord won't be present in wordList
            //wordList.remove(beginWord);
        Queue<String> queue=new ArrayDeque<>();
    
       queue.add(beginWord);
        int level=1;
        Iterator<String> itr;
        
        while(!queue.isEmpty())
        {
            int len=queue.size();
            for(int z=1;z<=len;z++)
            {
                String temp=queue.poll();
                if(temp.equals(endWord))
                    return level;
                itr=wordList.iterator();
                while(itr.hasNext())
                {
                    String comp=itr.next();
                    int count=0;                
                    for(int i=0;i<temp.length();i++)
                    {
                        if(temp.charAt(i)!=comp.charAt(i))
                            count++;                    
                    }
                    if(count==1)
                    {
                        queue.add(comp);
                        itr.remove();
                    }
                }
            }
            level++;
        }
        return 0;      
    }
}