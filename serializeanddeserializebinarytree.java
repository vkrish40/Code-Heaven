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
    int start_index=0;
    
    public void preorder(TreeNode root)
    {
        if(root==null)
        {
            serial+="*,";
            return;
        }
        serial+=root.val+",";
        preorder(root.left);
        preorder(root.right);         
    }
    public String serialize(TreeNode root) {
        
        preorder(root);
        return serial;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String str="";        
        for(int i=start_index;i<data.length();i++)
        {
            if(data.charAt(i)==',')
            {
                start_index=i+1;
                break;
            }
            
            str+=data.charAt(i);           
        }
        
        if(str.equals("*")|| start_index>=data.length())
        {
            return null;
        }   
        
        int temp=Integer.valueOf(str);
        TreeNode root=new TreeNode(temp);
        root.left=deserialize(data);
        root.right=deserialize(data);
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));