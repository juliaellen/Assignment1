import java.util.ArrayList;
import java.util.List;

class Node { 
    int data; 
    Node left, right; 
  
    Node(int value) { 
        data = value; 
        left = right = null; 
    } 
} 

public class LowestCommonAncestor<Key extends Comparable<Key>>
{
	class Node {
		private Node left;             
		private Node right;
		private Key data;
		private int N;             // number of nodes in subtree

		public Node(Key value, int N) {
			this.data = value;         // associated data
			left = right = null;	  // left and right subtrees
			this.N = N;
		}
	}
	private Node root;
	/**
	 *  Insert node into BST.
	 *  If key already exists, update with new value.
	 *
	 *  @param key the key to insert
	 *  @param val the value associated with key
	 */
	public void put(Key key) {
		if (key == null) {  return; }
		root = put(root, key);
	}

	private Node put(Node x, Key key) {
		if (x == null) return new Node(key, 1);
		int cmp = key.compareTo(x.data);
		if      (cmp < 0) x.left  = put(x.left,  key);
		else if (cmp > 0) x.right = put(x.right, key);
		else              x.data   = key;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}
