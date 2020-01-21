class TrieNode
{
    Map<Character, TrieNode> map;
    boolean endOfWord;
    public TrieNode()
    {
        map = new HashMap<>();
        endOfWord = false;
    }
}

class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++)
        {
            if(current.map.containsKey(word.charAt(i)))
            {
                current = current.map.get(word.charAt(i));
            }
            else
            {
                TrieNode node = new TrieNode();
                current.map.put(word.charAt(i), node);
                current = node;
            }
        }
        current.endOfWord = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++)
        {
            if(current.map.containsKey(word.charAt(i)))
            {
                current = current.map.get(word.charAt(i));
            }
            else
            {
                return false;
            }
        }
        
        return current.endOfWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++)
        {
            if(current.map.containsKey(prefix.charAt(i)))
            {
                current = current.map.get(prefix.charAt(i));
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */