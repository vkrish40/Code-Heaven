class TrieNode
{
    Map<Character,TrieNode> children;
    boolean endOfWord;
    public TrieNode()
    {
        children = new HashMap<>();
        endOfWord = false;
    }
}

class StreamChecker {
    
    TrieNode root = new TrieNode();
    List<Character> list = new ArrayList<>();
    public void addWord(String word)
    {
        TrieNode current = root;
        for(int i=word.length()-1;i>=0;i--)
        {
            if(current.children.containsKey(word.charAt(i)))
            {
                current = current.children.get(word.charAt(i));
            }
            else
            {
                TrieNode node = new TrieNode();
                current.children.put(word.charAt(i), node);
                current = node;
            }
        }
        current.endOfWord = true;
    }

    public StreamChecker(String[] words) {
        
        for(int i=0;i<words.length;i++)
        {
            addWord(words[i]);
        }        
    }
    
    public boolean query(char letter) {
        
        list.add(letter);  
        int len = list.size()-1;
        TrieNode current = root;
        while(len>=0 && current.children.containsKey(list.get(len)))
        {
            current = current.children.get(list.get(len));
            if(current.endOfWord)
                return true;
            len--;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */