class Solution {
    
    List<List<String>> ans;
    Map<String, List<String>> map;
    
    public void dfs(String word, List<String> list, String endWord)
    {
        list.add(word);
        if(word.equals(endWord))
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        List<String> temp_list = map.get(word);
        if(temp_list==null)
            return;
        Iterator<String> itr = temp_list.iterator();
        while(itr.hasNext())
        {
            String str = itr.next();
            dfs(str, list, endWord);
            list.remove(list.size()-1);
        }
        
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if(!dict.contains(endWord))
            return Arrays.asList();
        visited.add(beginWord);
        boolean flag = false;
        ans = new ArrayList<>();
        map = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while(!queue.isEmpty())
        {
            int len = queue.size();
            Set<String> temp_set = new HashSet<>();
            for(int i=1;i<=len;i++)
            {
                String word = queue.poll();
                char[] temp_word = word.toCharArray();
                for(int j=0;j<temp_word.length;j++)
                {
                    char temp = temp_word[j];
                    for(char ch='a';ch<='z';ch++)
                    {
                        if(ch==temp)
                            continue;
                        temp_word[j]=ch;
                        String str = String.valueOf(temp_word);
                        if(endWord.equals(str))
                        {
                            flag=true;
                        }
                        if(!visited.contains(str) && dict.contains(str))
                        {
                            if(!temp_set.contains(str))
                                queue.offer(str);
                            List<String> list = map.getOrDefault(word, new ArrayList<>());
                            list.add(str);
                            map.put(word, list);
                            temp_set.add(str);
                        }
                    }
                    temp_word[j]=temp;
                }
            }
            if(flag==true)
            {
                queue.clear();
            }
            visited.addAll(temp_set);
        }
        if(flag==false)
            return Arrays.asList();
        
        System.out.println(map);
        
        dfs(beginWord, new ArrayList<>(), endWord);
        
        return ans;      
        
        
    }
}