
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
 //mainclass
public class DagLCA{
@@ -12,6 +14,14 @@
	public boolean isDAG;
	public boolean[] marked; //boolean array for visited vertices
	public boolean[] stack; 
	
	// For DFS 
	public int[]pre;   
    public int[]post  ;
    public ArrayList<Integer> postorder;
    public ArrayList<Integer> preorder ;
    public int preCounter;
    public int postCounter;
	/**
	 * Initializes an empty digraph with <em>V</em> vertices.
	 *
@@ -26,11 +36,19 @@ public DagLCA(int V) {
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
			
		
		}
		isDAG = true;
		marked = new boolean[V];
		stack = new boolean[V];
	
		//for DFS
		pre    = new int[V()];
	    post   = new int[V()];
	    postorder = new ArrayList<Integer>();
	    preorder  = new ArrayList<Integer>();
	    preCounter=0;
	    postCounter=0;
	}
 @@ -60,7 +78,7 @@ public int E() {
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
		
 	}
 	/**
@@ -121,36 +139,85 @@ private void acyclic(int v)
		}
		stack[v] = false;
	}
	
 	public int LCA(int v, int w)
	{
		boolean haveLCA =false;
		//Will be acyclic if reversed so no need to reverse yet
		isAcyclic();
		if(!isDAG){
			return -1;
		}
		validateVertex(v);//exception thrown ifinvalid
		validateVertex(w);
		validateVertex(w);//check if they exist
		if(E==0)// no edges
		{
			return -1;
		}
		//is valid to search now reverse
 		DagLCA  reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
		
		reversed.dfs(v);        //Testing DFS first to see if it works       
		ArrayList<Integer> childVSearch =postorder;
		marked= new boolean[V()];
		
		pre    = new int[V()];
	    post   = new int[V()];
	    postorder = new ArrayList<Integer>();
	    preorder  = new ArrayList<Integer>();
	    preCounter=0;
	    postCounter=0;
	    reversed.dfs(w);
		ArrayList<Integer> childWSearch= postorder;
		for(int i = 0; i<childVSearch.size(); i++)
		{
			for(int t = 0; t<childWSearch.size(); t++)
			{		
				if(childVSearch.get(i)==childWSearch.get(t))
				{ // first occurence of a match is where the lowest common 
					commonAncestors.add(childVSearch.get(i));	
					haveLCA = true;
				}
			}
			
			
		}
		if(haveLCA)
			return commonAncestors.get(0);
		else
			
			return -1;
	}
	//reverse the DAG so we can navigate to parent nodes. cant be bothered incorporating parents with the add edge if thats even allowed
 	
	   private void dfs(int v) {
	        marked[v] = true;
	        pre[v] = preCounter++;
	        preorder.add(v);
	        for (int w : adj(v)) {
	            if (!marked[w]) {
	                dfs(w);
	            }
	        }
	        postorder.add(v);
	        post[v] = postCounter++;
	    }
	//reverse the DAG so we can navigate to parent nodes. cant be bothered incorporating parents with the add edge if thats even allowed
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
