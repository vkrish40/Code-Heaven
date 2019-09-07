/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    String serial="";
    int index=0;
    
    public void preorder(TreeNode root)
    {
        if(root==null)
            return;
        serial+=root.val+",";
        preorder(root.left);
        preorder(root.right);        
    }
    
    public String serialize(TreeNode root) {        
        preorder(root);
        return serial;      
    }
    
    public TreeNode reconstruct(String data, int min, int max)
    {
        String str="";
        int temp=index;
        TreeNode root=null;
        if(index>=data.length())
            return root;
        for(int i=index;i<data.length();i++)
        {
            if(data.charAt(i)==',')
            {
                index=i+1;
                break;
            }
            str+=data.charAt(i);
        }
        int val=Integer.valueOf(str);
        if(val>min && val<max)
        {
            root=new TreeNode(val);
            root.left=reconstruct(data, min, val);
            root.right=reconstruct(data, val, max);
        }
        else
        {
            index=temp;
        }
        return root;      
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        return reconstruct(data, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));







/*Solution using split function of String class*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    String serial="";
    int index=0;
    String[] numbers;
    
    public void preorder(TreeNode root)
    {
        if(root==null)
            return;
        serial+=root.val+",";
        preorder(root.left);
        preorder(root.right);        
    }
    
    public String serialize(TreeNode root) {        
        preorder(root);
        return serial;      
    }
    
    public TreeNode reconstruct(String[] numbers, int min, int max)
    {
        TreeNode root=null;
        if(index>=numbers.length)
            return root;
        
        int val=Integer.valueOf(numbers[index]);
        if(val>min && val<max)
        {
            root=new TreeNode(val);
            index++;
            root.left=reconstruct(numbers, min, val);
            root.right=reconstruct(numbers, val, max);
        }
        return root;      
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        numbers=data.split(",");
        return reconstruct(numbers, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));