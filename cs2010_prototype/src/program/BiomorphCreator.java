package program;
import java.util.Random;
/**
 * Factory class to generate a biomorph, assigning all its gene values.
 * @author Tom Connolly
 * @version 24/02/2015
 */
public class BiomorphCreator
{
	private Random rand;
	public BiomorphCreator()
	{
	}
	/**
	 * @return A new, randomly generated biomorph.
	 */
	public Biomorph createBiomorph()
	{
		rand = new Random();
		// The branch gene has been limited to a minimum of 3 to prevent a
		// simple line being generated.
		int branch = rand.nextInt(8) + 3;
		int branchIncrement = rand.nextInt(10);
		// Too many chains will freeze the program, so this has been limited to
		// 0-4.
		int chain = rand.nextInt(4)+1;
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		int curvature = rand.nextInt(10) + 1;
		int length = rand.nextInt(10) + 1;
		int lengthIncrement = rand.nextInt(10) + 1;
		int thickness = rand.nextInt(10) + 1;
		int thicknessIncrement = rand.nextInt(10) + 1;
		Biomorph biomorph = new Biomorph(branch, branchIncrement, chain, red, green, blue, curvature, length, lengthIncrement, thickness, thicknessIncrement);
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