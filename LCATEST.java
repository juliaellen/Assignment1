import static org.junit.Assert.*;
 import org.junit.Test;
 public class LCATEST {
 	@Test // test with no nodes
	public void testEmpty() {
		
	}
 	@Test // test with only one node in
	public void testSingle()
	{
		
	}
	
	@Test // test with multiple nodes
	public void testPopulated()
	{
		
	}
	@Test // test when left or right are not in the tree
	public void testNotInTree()
	{
			
	 		BST<Integer> test = new BST<Integer>();
			test.put(9);
			test.put(1);
			test.put(4);
			test.put(19);
			test.put(9);
			test.put(13);
			assertNull(LeastCommonAncestor(test.root,19,3));
	
		
	}
	@Test // test when v1 and v2 are the same value
	
	public void testSameValue()

		test.put(9);
		test.put(13);
		assertSame(test.search(test.root,9,9).key,9);
		assertSame(test.search(test.root,19,19).key,19);
	}
}