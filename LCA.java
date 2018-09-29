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

	public Node get(Key key)
	{
		return get(root, key);
		}

	private Node get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x;
	}


}