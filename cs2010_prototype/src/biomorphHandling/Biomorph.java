package biomorphHandling;
import org.lwjgl.opengl.GL11;
import genes.*;
import geometry.*;
/**
 * Class to model and draw a single biomorph.
 * @author Tom Connolly, Jack Taylor
 * @version 23/03/2015
 */
public class Biomorph
{
	// Enumerator for genes. Intended to replace genes[x] with genes[NAME], but I don't know how enums work in Java.
	/*
	 * enum genes
	 * {
	 * 		LENGTH,
	 * 		LENGTH_INCREMENT,
	 * 		THICKNESS,
	 * 		THICKNESS_INCREMENT,
	 * 		BRANCH,
	 * 		BRANCH_INCREMENT,
	 * 		CHAIN,
	 * 		COLOR_RED,
	 * 		COLOR_GREEN,
	 * 		COLOR_BLUE,
	 * 		IRIDESCENCE_RED,
	 * 		IRIDESCENCE_GREEN,
	 * 		IRIDESCENCE_BLUE
	 * }
	 */
	// An array is instantiated to hold 13 Genes that will be defined in the constructor.
	private Gene[] genes = new Gene[13];
	public Biomorph(int branchVal, int branchIncrementVal, int chainVal, int redVal, int greenVal, int blueVal, int lengthVal, int lengthIncrementVal, int thicknessVal, int thicknessIncrementVal, int iridRedVal, int iridGreenVal, int iridBlueVal)
	{
		// Genes are created and assigned values according to the parameters given. They are then placed in an array in
		// alphabetical (apart from colours which are RGB) order.
		genes[0] = new Branch(branchVal, "Branch");
		genes[1] = new BranchIncrement(branchIncrementVal, "Branch Increment");
		genes[2] = new Chain(chainVal, "Chain");
		genes[3] = new Color(redVal, "Color Red");
		genes[4] = new Color(greenVal, "Color Green");
		genes[5] = new Color(blueVal, "Color Blue");
		genes[6] = new Length(lengthVal, "Length");
		genes[7] = new LengthIncrement(lengthIncrementVal, "Length Increment");
		genes[8] = new Thickness(thicknessVal, "Thickness");
		genes[9] = new ThicknessIncrement(thicknessIncrementVal, "Thickness Increment");
		genes[10] = new Iridescence(iridRedVal, "Iridescence Red");
		genes[11] = new Iridescence(iridGreenVal, "Iridescence Green");
		genes[12] = new Iridescence(iridBlueVal, "Iridescence Blue");
	}
	/**
	 * Draws this biomorph.
	 */
	public void draw()
	{
		// int i = 0;
		// if (i < genes[8].getValue())
		// {
		GL11.glPushMatrix();
		{
			loop(genes[2].getValue(), 0);
			GL11.glPushMatrix();
			{
				GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
				loop(genes[2].getValue(), 0);
				GL11.glPushMatrix();
				{
					GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
					loop(genes[2].getValue(), 0);
				}
				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
		// increase the thickness of the biomorph.
		// i = (genes[8].getValue() + (i+genes[9].getValue()));
		// i++;
		// }
		// i = genes[9].getValue();
	}
	/**
	 * Recursive loop to draw chains from each branch.
	 * @param chains The amount of recursive steps
	 * @param limbCount The amount of limbs which have been drawn so far
	 */
	private void loop(int chains, int limbCount)
	{
		int length = genes[6].getValue() + ((genes[2].getValue() - chains) * genes[7].getValue());
		int thickness = genes[8].getValue() + ((genes[2].getValue() - chains) * genes[9].getValue());
		int red = (genes[3].getValue() + limbCount * genes[10].getValue()) % 256;
		int green = (genes[4].getValue() + limbCount * genes[11].getValue()) % 256;
		int blue = (genes[5].getValue() + limbCount * genes[12].getValue()) % 256;
		//Prevent length or thickness from going out of bounds
		if (length < 1) length = 1;
		if (length > 10) length = 10;
		if (thickness < 1) thickness = 1;
		if (thickness > 10) thickness = 10;
		// Set the thickness of the branches (Simple Limb only)
		GL11.glLineWidth(thickness);
		for (int b = 0; b < genes[0].getValue(); b++)
		{
			GL11.glPushMatrix();
			{
				// This allows the distribution of branches to be uniform.
				GL11.glRotatef((float) b * (360.0f / genes[0].getValue()), 0.0f, 0.0f, 1.0f);
				new CuboidLimb(length, thickness, red, green, blue).draw();
			}
			GL11.glPopMatrix();
			limbCount++;
			// This draws a new set of branches from the end of each existing branch if necessary.
			if (chains > 1)
			{
				GL11.glPushMatrix();
				{
					GL11.glRotatef((float) b * (360.0f / genes[0].getValue()), 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(0.0f, genes[6].getValue() + ((genes[2].getValue() - chains + 1) * genes[7].getValue()), 0.0f);
					loop(chains - 1, limbCount);
				}
				GL11.glPopMatrix();
			}
		}
	}
	/**
	 * @return An array containing a value for each Gene of this biomorph
	 */
	public Gene[] getGenes()
	{
		return genes;
	}
}