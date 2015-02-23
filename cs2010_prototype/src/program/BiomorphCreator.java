package program;
import java.util.Random;
/**
 * Factory class to generate a random biomorph.
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
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
		int branch = rand.nextInt(8) + 3;
		int branchIncrement = rand.nextInt(10);
		//Too many chains will freeze the program, so this has been limited to 0-4.
		int chain = rand.nextInt(5);
		int colorB = rand.nextInt(10) + 1;
		int colorG = rand.nextInt(10) + 1;
		int colorR = rand.nextInt(10) + 1;
		int curvature = rand.nextInt(10) + 1;
		int length = rand.nextInt(10) + 1;
		int lengthIncrement = rand.nextInt(10) + 1;
		int thickness = rand.nextInt(10) + 1;
		int thicknessIncrement = rand.nextInt(10) + 1;
		
		Biomorph biomorph = new Biomorph(branch, branchIncrement, chain, colorB, colorG, colorR, curvature, length, lengthIncrement, thickness, thicknessIncrement);
		return biomorph;
	}
	
	/**
	 * @return A new biomorph that's genes have values that are given.
	 */
	public Biomorph createBiomorph(int branch, int branchIncrement, int chain, int colorB, int colorG, int colorR, int curvature, int length, int lengthIncrement, int thickness, int thicknessIncrement)
	{		
		Biomorph biomorph = new Biomorph(branch, branchIncrement, chain, colorB, colorG, colorR, curvature, length, lengthIncrement, thickness, thicknessIncrement);

		return biomorph;
	}
}