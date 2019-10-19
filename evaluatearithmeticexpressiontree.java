/*evaluate an arithmetic expression tree: just write the data structure for the tree and function to evaluate the tree*/

class node{

	String val;
	node left;
	node right;

	public node(String val)
	{
		this.val=val;
	}
}
 

class evaluate{

	public node postorder(node root)
	{
		if(root==null)
			return root;
		root.left=postorder(root.left);
		root.right=postorder(root.right);
		if(root.left==null && root.right==null)
			return root;
		int a=Integer.parseInt(root.left.val);
		int b=Integer.parseInt(root.right.val);
		int result=0;
	
		if(root.val.equals("+"))
			result=a+b;
		if(root.val.equals("-"))
			result=a-b;
		if(root.val.equals("*"))
			result=a*b;
		if(root.val.equals("/"))
			result=a/b;

		root.val=""+result;

		return root;
	}

	public static void main(String[] args)
	{
		/*I am assuming we already have expression tree built whose root node is provided to us and that tree is built using the 
		node data structure defined above*/	

		root=postorder(root);

		System.out.println(Integer.parseInt(root.val));	
	}

}


	
	
	
