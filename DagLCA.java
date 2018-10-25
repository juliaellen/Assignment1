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
	public DagLCA(int V) 
	{
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) 
		{
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
		public int V() 
		{
			return V;
		}
		public Node get(Key key)
		{
			return get(root, key);
		}
		private Node get(Node x, Key key) 
		{
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
			public int E()
			{
				return E;
			}

			// throw an IllegalArgumentException unless {@code 0 <= v < V}
			private void validateVertex(int v) 
			{
				if (v < 0 || v >= V)
					throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
			}
		}
		/**
		 * Adds the directed edge v-w to this digraph.
		 *
		 * @param  v the tail vertex
		 * @param  w the head vertex
		 * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
		 */
		public void addEdge(int v, int w) 
		{
			validateVertex(v);
			validateVertex(w);
			adj[v].add(w);
			indegree[w]++;
			E++;
		}
		public Node search(Node root, Key v1, Key v2)
		{
			if(root != null && (get(v1)!=null && get(v2)!=null))
			{
				/**
				 * Returns the vertices adjacent from vertex {@code v} in this digraph.
				 *
				 * @param  v the vertex
				 * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
				 * @throws IllegalArgumentException unless {@code 0 <= v < V}
				 */
				public Iterable<Integer> adj(int v) {
					validateVertex(v);
					return adj[v];
				}
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
					public boolean acyclic()
					{
						return isDAG;	
					}
					//Sedgewick
					public void acyclic(int v)
					{
						stack[v] =true; 
						marked[v] = true;
						for (int w : adj(v)) {
							if(!marked[w]) {
								acyclic(w);
							} else if (stack[w]) {
								isDAG = false;
								return;
							}
							else if(rightBranch != null)
							{
								return rightBranch;
							}
							else 
								return null;
						}
						return null;
						stack[v] = false;
					}
				}
			}
		}
	}
	private void validateVertex(int v) 
	{
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));

	}


	public int LCA(int v, int w)
	{
		isAcyclic();
		if(!isDAG){
			return -1;
		}
		validateVertex(v);//exception thrown ifinvalid
		validateVertex(w);



		if(E==0)// no edges
		{
			return -1;
		}
	}
	public DagLCA reverse() {
        DagLCA childToParent = new DagLCA(V);
        for (int v = 0; v < V; v++) 
        {
            
        	for (int w : adj(v)) 
        	{
            	childToParent.addEdge(w, v);
            }
        }
        return childToParent;
    }
}


