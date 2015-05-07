package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import biomorphHandling.*;
public class Biomorph_Test
{
	private Biomorph biomorph;
	private int[] values = {4, 2, 5, 2, 3, 1, 128, 128, 128, 4, 4, 4};
	@Before
	public void setUp()
	{
		biomorph = new Biomorph(null, null, 4, 2, 5, 2, 3, 1, 128, 128, 128, 4, 4, 4);
	}
	@Test
	// Tests whether the gene values have been assigned to the Biomorph correctly.
	public void testGeneValues()
	{
		for (int i = 0; i < biomorph.getGenes().length; i++)
		{
			assertEquals(biomorph.getGenes()[i].getValue(), values[i]);
		}
	}
}