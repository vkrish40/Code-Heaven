/******************************************************************************

                            Implementing a trie

*******************************************************************************/
import java.util.*;

class TrieNode
{
    Map<Character,TrieNode> children;
    boolean endOfWord;
    public TrieNode()
    {
        children=new HashMap<>();
        endOfWord=false;
    }
}

public class Main
{
    TrieNode root = new TrieNode();
	public void insert(String word)
	{
	    TrieNode current = root;
	    for(int i=0;i<word.length();i++)
	    {
	        if(current.children.containsKey(word.charAt(i)))
	        {
	            current=current.children.get(word.charAt(i));
	        }
	        else
	        {
	            TrieNode node = new TrieNode();
	            current.children.put(word.charAt(i),node);
	            current=node;
	        }
	    }
	    current.endOfWord=true;
	}
	
	public boolean search(String word)
	{
	    TrieNode current = root;
	    for(int i=0;i<word.length();i++)
	    {
	        if(current.children.containsKey(word.charAt(i)))
	        {
	            current=current.children.get(word.charAt(i));
	        }
	        else
	            return false;
	    }
	    return current.endOfWord;
	}
	
	public void delete(String word)
	{
	    delete(word,root,0);
	}
	
	public boolean delete(String word, TrieNode root, int index)
	{
	    if(index==word.length())
	    {
	        if(!root.endOfWord)
	            return false;
	        root.endOfWord=false;
	        
	        return root.children.size()==0;
	    }
	    TrieNode node = root.children.get(word.charAt(index));
	    if(root==null)
	        return false;
	    boolean deleteEntry = delete(word, node, index+1);
	    if(deleteEntry)
	    {
	        root.children.remove(word.charAt(index));
	        return root.children.size()==0;
	    }
	    return false;
	}
	
	public void start()
	{
	    insert("varun");
	    insert("varunn");
	    System.out.println("Before deletion(varun): " + search("varun"));
	    delete("varun");
	    System.out.println("After deletion(varun): " + search("varun"));
	    System.out.println("After deletion(varun) searching for (varunn): " + search("varunn"));
	}
	
	public static void main(String[] args)
	{
	    Main obj = new Main();
	    obj.start();
	}
}
