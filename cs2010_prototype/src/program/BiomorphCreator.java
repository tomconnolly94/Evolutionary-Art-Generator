package program;
import java.util.Random;

/**
 * Factory class to generate a random biomorph.
 * 
 * @author Tom Connolly
 * @version 22 Nov 2014
 */

public class BiomorphCreator
{
	private Random rand;	
	public BiomorphCreator()
	{	
		rand = new Random();
	}
	/**
	 * @return A new, randomly generated biomorph.
	 */
	public Biomorph createBiomorph()
	{	
		//The branch gene has been limited to a minimum of 3 to prevent a simple line being generated.
		int gene1 = rand.nextInt(8) + 3;
		//Too many chains will freeze the program, so this has been limited to 0-4.
		int gene2 = rand.nextInt(5);
		int gene3 = rand.nextInt(10) + 1;
		int gene4 = rand.nextInt(10) + 1;
		Biomorph biomorph = new Biomorph(gene1, gene2, gene3, gene4);
		return biomorph;
	}
}
