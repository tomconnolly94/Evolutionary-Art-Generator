package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import biomorphHandling.*;
public class BiomorphCreator_Test
{
	private BiomorphCreator bc;
	private Biomorph biomorphRand;
	private Biomorph biomorphNonRand;
	//Gene values generated when seed for RNG is 10
	private int[] geneValues = {8, 2, 105, 15, 172, 2, 0, 2, -2, -1, 3, -3};
	@Before
	// pre-conditions
	public void setUp()
	{
		/*
		 * for test to pass the seed in biomorphCreator must be set to 10. this
		 * means the random factor of the createBiomorph class can be tested.
		 */
		bc = new BiomorphCreator();
		biomorphRand = bc.createBiomorph();
		biomorphNonRand = bc.createBiomorph(geneValues[0], geneValues[1], geneValues[2], geneValues[3], geneValues[4], geneValues[5], geneValues[6], geneValues[7], geneValues[8], geneValues[9], geneValues[10], geneValues[11]);
	}
	@Test
	public void testRandValues()
	{
		for (int i = 0; i < biomorphRand.getGenes().length; i++)
		{
			assertEquals(biomorphRand.getGenes()[i].getValue(), geneValues[i]);
		}
	}
	@Test
	public void testNonRandValues()
	{
		for (int i = 0; i < biomorphNonRand.getGenes().length; i++)
		{
			assertEquals(biomorphNonRand.getGenes()[i].getValue(), geneValues[i]);
		}
	}
}