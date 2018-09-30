import static org.junit.Assert.*;

import org.junit.Test;

//Using JUNIT FrameWork
public class LCATEST {
	
	@Test // test with no nodes
	public void testEmpty() {
		LCA<Integer> testBST = new LCA<Integer>();
		
		assertNull( testBST.search(testBST.root, 7, 1));
	}

	