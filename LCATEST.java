import static org.junit.Assert.*;

import org.junit.Test;

//Using JUNIT FrameWork
public class LCATEST {
	
	@Test // test with no nodes
	public void testEmpty() {
		LCA<Integer> testBST = new LCA<Integer>();
		
		assertNull( testBST.search(testBST.root, 7, 1));
	}

	@Test // test with only one node in
	public void testSingle()
	{
		LCA<Integer> testBST = new LCA<Integer>();
		testBST.put(7);
		assertNull(testBST.search(testBST.root,1,3));
		
	}
	
