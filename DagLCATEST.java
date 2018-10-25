import java.util.ArrayList;
//Using JUNIT FrameWork
public class DagLCATEST 
{

	// testing functions based on DAG similar to SEdgwick AdjMatrix implementation
	@Test
	public test
	public void testV()
	{
		DagLCA test1 = new DagLCA(20);
		assertEquals("testing V() function", 20, test1.V());
	}
	@Test
	public void testE()
	{
		DagLCA test1 = new DagLCA(13);
		assertEquals("testing with no edges",0,test1.E());
		test1.addEdge(1, 2);
		assertEquals("testing with no edges",1,test1.E());
	}
	@Test
	public void testAcyclic()
	{
		DagLCA test1 = new DagLCA(13);//hopefully not unlucky
		test1.addEdge(1, 2);
		test1.addEdge(2, 3);
		test1.addEdge(3, 4);
		assertTrue(test1.acyclic())
		assertTrue(test1.acyclic());
		test1.addEdge(4,1);
		assertFalse(test1.acyclic());

	}

	@Test
	public void testLCA()
	{
		DagLCA test1 = new DagLCA(10);
		test1.addEdge(1, 2);
		test1.addEdge(2, 3);
		test1.addEdge(3, 4);
		test1.addEdge(3, 5);
		assertEquals("We know it it 3",3,test1.LCA(4,5));
		assertEquals("We know it it 3",3,test1.LCA(5,4));
		test1.addEdge(5, 6);
		test1.addEdge(4, 7);
		test1.addEdge(7,8);
		test1.addEdge(6, 9);
		test1.addEdge(9,10);//joins the branches
		test1.addEdge(8, 10);
		assertEquals("LCA should be at the branch poin 3",3, test1.LCA(9,7));
		assertEquals("LCA of two of the same line", 7,test1.LCA(7,8));

	}
	@Test(expected = IllegalArgumentException.class) 
	public void testExceptionThrowers() // tested through the adj function giving errors
	{

		DagLCA test = new DagLCA(6);
		test.adj(-1);
		test.adj(88);
		test.LCA(1, -1);
		test.LCA(1, 88);
		DagLCA test2 = new DagLCA(-4); //shouldnt have negative vertices for our purposes
	}

}
