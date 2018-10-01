public class Node{
		Node left, right;
		Key key;		
		
 		public Node(Key key)
		{
			this.key = key;
		}
	}
 	public Node root;
	
	
 	public void put(Key key)
	{
		root = put(root, key);
// -34,32 +34,37 @@ private Node put(Node x, Key key)
		}
		return x;
	}
	
 	
	
	
 	public Node search(Node root, Key v1, Key v2)
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
 		 else 
 			 return rightBranch;
 		}
 			if(root != null)
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
 				else 
 					return rightBranch;
 			}
 			return null;
 		}
 	}