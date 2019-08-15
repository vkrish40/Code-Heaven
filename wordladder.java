class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord))
            return 0;
        if(wordList.contains(beginWord))
            wordList.remove(beginWord);
        Queue<String> currlevel=new LinkedList<>();
        Queue<String> nextlevel=new LinkedList<>();
        nextlevel.add(beginWord);
        int level=1;
        Iterator<String> itr;
        
        while(!nextlevel.isEmpty())
        {
            currlevel=nextlevel;
            nextlevel=new LinkedList<>();
            while(!currlevel.isEmpty())
            {
                String temp=currlevel.poll();
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
                        nextlevel.add(comp);
                        itr.remove();
                    }
                }
            }
            level++;
        }
        return 0;      
    }
}