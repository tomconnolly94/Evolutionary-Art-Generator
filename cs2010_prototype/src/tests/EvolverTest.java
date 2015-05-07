package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import evolution.Evolver;
import genes.Gene;
import biomorphHandling.Biomorph;
public class EvolverTest
{
	private Evolver e;
	private int[] targetValues = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	@Before
	public void setup()
	{
		Biomorph b1 = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Biomorph b2 = new Biomorph(null, null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
		e = new Evolver(b1, b2, targetValues);
	}
	@Test
	public void testEvolveClo()
	{
		Biomorph b3 = e.evolveClo();
		Gene[] genes = b3.getGenes();
		for (int i = 0; i < genes.length; i++)
		{
			// asserts that the child gene value is the same of the parent that is closest
			// to the target values, in this case parent 1's genes are all closer so the values
			// should all be 0.
			assertEquals(genes[i].getValue(), 0);
		}
	}
	public void testEvolveAv()
	{
		Biomorph b3 = e.evolveAv();
		Gene[] genes = b3.getGenes();
		for (int i = 0; i < genes.length; i++)
		{
			// the average of 0 and 10(parent Biomorphs gene values) is 5 so all the child genes should be 5
			assertEquals(genes[i].getValue(), 5);
		}
	}
}