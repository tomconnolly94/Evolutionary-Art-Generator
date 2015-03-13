package tests;

import static org.junit.Assert.*;
import genes.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import biomorphHandling.*;

public class BiomorphCreator_Test
{
	private BiomorphCreator bc;
	
	@Before
	public void setUp()
	{
		bc = new BiomorphCreator();
		bc.createBiomorph();
	}
	
	
	@Test
	public void test()
	{
		
	}
}
