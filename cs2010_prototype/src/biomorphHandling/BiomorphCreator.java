package biomorphHandling;
import java.util.Random;
/**
 * Factory class to generate a biomorph, assigning all its gene values.
 * @author Tom Connolly
 * @version 24/04/2015
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
		rand = new Random(/* 10 */); // Seed used for testing
		int branch = rand.nextInt(8) + 3; // Value: 3 to 10 (The branch gene has been limited to a minimum of 3 to prevent a simple line from being generated)
		int chain = rand.nextInt(4) + 1; // Value: 1 to 4 (Too many chains will freeze the program)
		int red = rand.nextInt(256); // Value: 0 to 255
		int green = rand.nextInt(256); // Value: 0 to 255
		int blue = rand.nextInt(256); // Value: 0 to 255
		int length = rand.nextInt(8) + 1; // Value: 1 to 8
		int lengthIncrement = rand.nextInt(7) - 3; // Value: -3 to 3
		int thickness = 1; //rand.nextInt(10) + 1; // Value: 1 to 10
		int thicknessIncrement = 0; //rand.nextInt(7) - 3; // Value: -3 to 3
		int iridRed = rand.nextInt(33) - 8; // Value: -16 to 16
		int iridGreen = rand.nextInt(33) - 8; // Value: -16 to 16
		int iridBlue = rand.nextInt(33) - 8; // Value: -16 to 16
		Biomorph biomorph = new Biomorph(branch, chain, red, green, blue, length, lengthIncrement, thickness, thicknessIncrement, iridRed, iridGreen, iridBlue);
		return biomorph;
	}
	/**
	 * @return A new biomorph whose genes have values that are given.
	 */
	public Biomorph createBiomorph(int branch, int chain, int red, int green, int blue, int length, int lengthInc, int thickness, int thicknessInc, int iridRed, int iridGreen, int iridBlue)
	{
		return new Biomorph(branch, chain, red, green, blue, length, lengthInc, thickness, thicknessInc, iridRed, iridGreen, iridBlue);
	}
}