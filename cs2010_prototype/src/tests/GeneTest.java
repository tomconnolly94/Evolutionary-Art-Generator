package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import biomorphHandling.BiomorphCreator;
import genes.Gene;
public class GeneTest
{
	private Gene[] genes;
	@Before
	public void setUp()
	{
		//BiomorphCreator seed must be 10
		genes = new BiomorphCreator().createRandomBiomorph().getGenes();
	}
	@Test
	public void testValues()
	{
		assertEquals(8, genes[0].getValue());
		assertEquals(1, genes[1].getValue());
		assertEquals(3, genes[2].getValue());
		assertEquals(2, genes[3].getValue());
		assertEquals(7, genes[4].getValue());
		assertEquals(3, genes[5].getValue());
		assertEquals(62, genes[6].getValue());
		assertEquals(94, genes[7].getValue());
		assertEquals(209, genes[8].getValue());
		assertEquals(15, genes[9].getValue());
		assertEquals(12, genes[10].getValue());
		assertEquals(7, genes[11].getValue());
	}
	@Test
	public void testNames()
	{
		assertEquals("Branch", genes[0].getGeneType());
		assertEquals("Chain", genes[1].getGeneType());
		assertEquals("Length", genes[2].getGeneType());
		assertEquals("Length Increment", genes[3].getGeneType());
		assertEquals("Thickness", genes[4].getGeneType());
		assertEquals("Thickness Increment", genes[5].getGeneType());
		assertEquals("Color Red", genes[6].getGeneType());
		assertEquals("Color Green", genes[7].getGeneType());
		assertEquals("Color Blue", genes[8].getGeneType());
		assertEquals("Iridescence Red", genes[9].getGeneType());
		assertEquals("Iridescence Green", genes[10].getGeneType());
		assertEquals("Iridescence Blue", genes[11].getGeneType());
	}
}