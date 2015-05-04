package biomorphHandling;
import java.util.Random;
/**
 * Factory class to generate a biomorph, assigning all its gene values.
 * @author Tom Connolly
 * @version 04/05/2015
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
	public Biomorph createRandomBiomorph()
	{
		rand = new Random(/* 10 */); // Seed used for testing
		int branch = rand.nextInt(8) + 3; // Value: 3 to 10 (The branch gene has been limited to a minimum of 3 to prevent a simple line from being generated)
		int chain = rand.nextInt(3) + 1; // Value: 1 to 3 (Too many chains will freeze the program)
		int length = rand.nextInt(8) + 1; // Value: 1 to 8
		int lengthIncrement = rand.nextInt(7) - 3; // Value: -3 to 3
		int thickness = rand.nextInt(10) + 1; // Value: 1 to 10
		int thicknessIncrement = rand.nextInt(7) - 3; // Value: -3 to 3
		int red = rand.nextInt(256); // Value: 0 to 255
		int green = rand.nextInt(256); // Value: 0 to 255
		int blue = rand.nextInt(256); // Value: 0 to 255
		int iridRed = rand.nextInt(33) - 16; // Value: -16 to 16
		int iridGreen = rand.nextInt(33) - 16; // Value: -16 to 16
		int iridBlue = rand.nextInt(33) - 16; // Value: -16 to 16
		Biomorph biomorph = new Biomorph(null, null, branch, chain, length, lengthIncrement, thickness, thicknessIncrement, red, green, blue, iridRed, iridGreen, iridBlue);
		return biomorph;
	}
	/**
	 * @return A new biomorph whose genes have values that are given.
	 */
	public Biomorph createBiomorph(Biomorph father, Biomorph mother, int branch, int chain, int length, int lengthInc, int thickness, int thicknessInc, int red, int green, int blue, int iridRed, int iridGreen, int iridBlue)
	{
		return new Biomorph(father, mother, branch, chain, length, lengthInc, thickness, thicknessInc, red, green, blue, iridRed, iridGreen, iridBlue);
	}
}