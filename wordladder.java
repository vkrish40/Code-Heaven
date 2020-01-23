class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int count = 0;
        while(!queue.isEmpty())
        {
            int len = queue.size();
            for(int i=1;i<=len;i++)
            {
                String word = queue.poll();
                if(endWord.equals(word))
                    return count+1;
                char[] word_arr = word.toCharArray();
                for(int j=0;j<word_arr.length;j++)
                {
                    char temp = word_arr[j];
                    for(char ch='a';ch<='z';ch++)
                    {
                        if(temp==ch)
                            continue;
                        word_arr[j] = ch;
                        String temp_word = String.valueOf(word_arr);
                        if(dict.contains(temp_word))
                        {
                            queue.offer(temp_word);
                            dict.remove(temp_word);
                        }
                    }
                    word_arr[j]=temp;
                }
            }
            count++;
        }
        return 0;
    }
}