package tests;

import static org.junit.Assert.*;
import genes.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import biomorphHandling.*;

//class to test all features of the Biomorph Class
public class BiomorphTest
{
	private Biomorph biomorph;
	private Gene[] genes;
	
	@Before //pre-conditions
	public void setUp()
	{
		biomorph = new Biomorph(2,2,4,100,100,100,5,2,3,1);
		
		genes[0] = new Branch(2, "Branch");
		genes[1] = new BranchIncrement(2, "Branch Increment");
		genes[2] = new Chain(4, "Chain");
		genes[3] = new Color(100, "Color Red");
		genes[4] = new Color(100, "Color Green");
		genes[5] = new Color(100, "Color Blue");
		genes[6] = new Length(5, "Length");
		genes[7] = new LengthIncrement(2, "Length Increment");
		genes[8] = new Thickness(3, "Thickness");
		genes[9] = new ThicknessIncrement(1, "Thickness Increment");
	}
	
	@Test //tests
	public void test()
	{
		assertEquals(biomorph.getGenes(), genes );
		
	}
	
	@After //post conditions
	public void cleanUp()
	{
		
	}
}
