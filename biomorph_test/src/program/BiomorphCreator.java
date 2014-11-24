package program;
import java.util.Random;
public class BiomorphCreator
{
	private Random rand;	
	public BiomorphCreator()
	{	
		rand = new Random();
	}
	public Biomorph createBiomorph()
	{	
		int gene1 = rand.nextInt(10) + 1;
		int gene2 = rand.nextInt(5); //Too many chains will freeze the program.
		int gene3 = rand.nextInt(10) + 1;
		int gene4 = rand.nextInt(10) + 1;
		Biomorph biomorph = new Biomorph(gene1, gene2, gene3, gene4);
		return biomorph;
	}
}