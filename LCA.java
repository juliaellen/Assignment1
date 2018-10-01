//Main class
public class LCA{
 	public Node search(Node root, int v1, int v2)
	{
	 if(root.val == v1 || root.val == v2)
	 {
		 return root;
	 }
	 
	 Node leftBranch = search(root.left, v1,v2);
	 Node rightBranch = search(root.right,v1,v2);
	 //If they both have an answer this is the LCA 
	 if(leftBranch != null && rightBranch != null)
	 {
		 return root;
	 }
	 if(leftBranch != null) // find and return the node with the value returns null if neither have the value
	 {
		 return leftBranch;
		
	 }
	 else 
		 return rightBranch;
	}
 }
