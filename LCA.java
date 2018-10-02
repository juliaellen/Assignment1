

//Main class
public class LCA<Key extends Comparable<Key>>{


	public Node search(Node root, Key v1, Key v2)
	{
		if(root != null &&(get(v1)!=null &&get(v2)!=null))
		{


			if(root.key.compareTo(v1) == 0 || root.key.compareTo(v2) == 0)
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
			else if(rightBranch != null)
			{
				return rightBranch;
			}
			else 
				return null;
		}
		return null;
	}
}
