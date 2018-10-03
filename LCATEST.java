import static org.junit.Assert.*;
import org.junit.Test;
public class LCATEST {


	@Test // test with no nodes
	public void testEmpty() {
		LCA<Integer> testBST = new LCA<Integer>();
		LCA testBST = new LCA();

		assertNull( testBST.search(testBST.root, 7, 1));
	}

	public void testSingle()
	{

	}

	public void testGet()
	{
		LCA<Integer> bst = new LCA<Integer>(); 	
		assertSame("test get empty tree", null, bst.get(7));
		assertNull("test get empty tree", bst.get(7));
		bst.put(1);
		assertSame("test single tree", 1, bst.get(1));
		assertSame("test single tree", 1, bst.get(1).key);
		bst.put(2);
		bst.put(4);
		bst.put(5);
		assertSame("test value larger than root",4, bst.get(4));
		assertSame("test value smaller than root", 2, bst.get(2));
		assertSame("test value larger than root",4, bst.get(4).key);
		assertSame("test value smaller than root", 2, bst.get(2).key);
		assertSame("test value larger but not in tree", null, bst.get(11));
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
@Test 
public void testIsAcyclic()
{
	LCA test = new LCA();
	Node b = new Node(1,"B");
	test.put(b);
	assertTrue(test.isAcyclic());// test single node
	Node a = new Node(1,"A");
	test.put(a);
	b.addEdgeTo(a);
	assertTrue(test.isAcyclic); // test two nodes acyclic
	a.addEdgeTo(b);
	assertFalse(test.isAcyclic); // test two nodes cyclic


}
}