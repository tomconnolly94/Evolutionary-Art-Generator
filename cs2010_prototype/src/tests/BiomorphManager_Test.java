package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import biomorphHandling.*;
public class BiomorphManager_Test
{
	private BiomorphManager bm;
	@Before
	public void setUp()
	{
		bm = new BiomorphManager();
	}
	@Test
	public void testSize()
	{
		assertEquals(3, bm.cloneCollection().size());
	}
	@Test
	public void testCreateAndAdd()
	{
		bm.createAndAdd();
		assertEquals(4, bm.cloneCollection().size());
	}
	@Test
	public void testRemove()
	{
		int size = bm.cloneCollection().size();
		bm.remove(0);
		assertEquals(size - 1, bm.cloneCollection().size());
	}
}
