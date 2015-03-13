package tests;

import static org.junit.Assert.*;
import genes.*;
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
	public void test()
	{
		assertEquals(3,bm.cloneCollection().size());
	}

}
