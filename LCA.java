//Main class
public class LCA<Key extends Comparable<Key>>{

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
	}

	private Node put(Node x, Key key)
	{
		if(x==null){
			return new Node(key);
		}
		int cmp = key.compareTo(x.key);
		if(cmp<0){
			x.left = put(x.left, key);
		}else if(cmp>0){
			x.right = put(x.right, key);
		}
		return x;
	}

	