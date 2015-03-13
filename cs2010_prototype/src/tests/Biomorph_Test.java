package tests;

import static org.junit.Assert.*;
import genes.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import biomorphHandling.*;

//class to test all features of the Biomorph Class
public class Biomorph_Test
{
	private Biomorph biomorph;
	private int[] values = {2,2,4,100,100,100,5,2,3,1};
	
	@Before //pre-conditions
	public void setUp()
	{
		biomorph = new Biomorph(2,2,4,100,100,100,5,2,3,1);
		
		
	}
	
	@Test //tests whether the gene values have been assigned to the Biomorph correctly.
	public void testGeneValues()
	{
		for(int i=0; i<biomorph.getGenes().length; i++){
		assertEquals(biomorph.getGenes()[i].getValue(), values[i]);
		}
	}
	
	@After //post conditions
	public void cleanUp()
	{
		
	}
}
