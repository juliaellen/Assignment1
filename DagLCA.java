import java.util.ArrayList;
public class DagLCA {

	//I am using a graph implementation similar to 
	//https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
	//I am not trying to reinvent the wheel as was suggested to us
	
	private final int V;           // number of vertices in this digraph
	private int E;                 // number of edges in this digraph
	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;        // indegree[v] = indegree of vertex v
	public boolean isDAG;
	public boolean[] marked; //boolean array for visited vertices
	public boolean[] stack; 
	/**
	 * Initializes an empty digraph with <em>V</em> vertices.
	 *
	 * @param  V the number of vertices
	 * @throws IllegalArgumentException if {@code V < 0}
	 */
	public DagLCA(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
		isDAG = true;
		boolean[] marked = new boolean[V];
		boolean[] stack = new boolean[V];
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
	/**
	 * Returns the number of vertices in this digraph.
	 *
	 * @return the number of vertices in this digraph
	 */
	public int V() {
		return V;
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
	/**
	 * Returns the number of edges in this digraph.
	 *
	 * @return the number of edges in this digraph
	 */
	public int E() {
		return E;
	}

}
