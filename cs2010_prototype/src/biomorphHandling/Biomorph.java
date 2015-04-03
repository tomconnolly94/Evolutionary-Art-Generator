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
	// Enumerator for gene names (the "gene-umerator")
	enum GeneNames
	{
		BRANCH,
		BRANCH_INCREMENT,
		CHAIN,
		COLOR_RED,
		COLOR_GREEN,
		COLOR_BLUE,
		LENGTH,
		LENGTH_INCREMENT,
		THICKNESS,
		THICKNESS_INCREMENT,
		IRIDESCENCE_RED,
		IRIDESCENCE_GREEN,
		IRIDESCENCE_BLUE
	}
	// After figuring out how to access something as simple as the number a certain value represents, I can now say I HATE Java enums.
	// Seriously, to access 0, it's genes[GeneNames.LENGTH.ordinal()]. In C++ it would just be genes[LENGTH].
	// An array is instantiated to hold 13 Genes that will be defined in the constructor.
	private Gene[] genes = new Gene[13];
	public Biomorph(int branchVal, int branchIncrementVal, int chainVal, int redVal, int greenVal, int blueVal, int lengthVal, int lengthIncrementVal, int thicknessVal, int thicknessIncrementVal, int iridRedVal, int iridGreenVal, int iridBlueVal)
	{
		// Genes are created and assigned values according to the parameters given. They are then placed in an array in
		// alphabetical (apart from colours which are RGB) order.
		genes[GeneNames.BRANCH.ordinal()] = new Branch(branchVal, "Branch");
		genes[GeneNames.BRANCH_INCREMENT.ordinal()] = new BranchIncrement(branchIncrementVal, "Branch Increment");
		genes[GeneNames.CHAIN.ordinal()] = new Chain(chainVal, "Chain");
		genes[GeneNames.COLOR_RED.ordinal()] = new Color(redVal, "Color Red");
		genes[GeneNames.COLOR_GREEN.ordinal()] = new Color(greenVal, "Color Green");
		genes[GeneNames.COLOR_BLUE.ordinal()] = new Color(blueVal, "Color Blue");
		genes[GeneNames.LENGTH.ordinal()] = new Length(lengthVal, "Length");
		genes[GeneNames.LENGTH_INCREMENT.ordinal()] = new LengthIncrement(lengthIncrementVal, "Length Increment");
		genes[GeneNames.THICKNESS.ordinal()] = new Thickness(thicknessVal, "Thickness");
		genes[GeneNames.THICKNESS_INCREMENT.ordinal()] = new ThicknessIncrement(thicknessIncrementVal, "Thickness Increment");
		genes[GeneNames.IRIDESCENCE_RED.ordinal()] = new Iridescence(iridRedVal, "Iridescence Red");
		genes[GeneNames.IRIDESCENCE_GREEN.ordinal()] = new Iridescence(iridGreenVal, "Iridescence Green");
		genes[GeneNames.IRIDESCENCE_BLUE.ordinal()] = new Iridescence(iridBlueVal, "Iridescence Blue");
	}
	/**
	 * Draws this biomorph.
	 */
	public void draw()
	{
		GL11.glPushMatrix();
		{
			loop(genes[GeneNames.CHAIN.ordinal()].getValue(), 0);
			GL11.glPushMatrix();
			{
				GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
				loop(genes[GeneNames.CHAIN.ordinal()].getValue(), 0);
				GL11.glPushMatrix();
				{
					GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
					loop(genes[GeneNames.CHAIN.ordinal()].getValue(), 0);
				}
				GL11.glPopMatrix();
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}
	/**
	 * Recursive loop to draw chains from each branch.
	 * @param chains The amount of recursive steps
	 * @param limbCount The amount of limbs which have been drawn so far
	 */
	private void loop(int chains, int limbCount)
	{
		int length = genes[GeneNames.LENGTH.ordinal()].getValue() + ((genes[GeneNames.CHAIN.ordinal()].getValue() - chains) * genes[GeneNames.LENGTH_INCREMENT.ordinal()].getValue());
		int thickness = genes[GeneNames.THICKNESS.ordinal()].getValue() + ((genes[GeneNames.CHAIN.ordinal()].getValue() - chains) * genes[GeneNames.THICKNESS_INCREMENT.ordinal()].getValue());
		int red = (genes[GeneNames.COLOR_RED.ordinal()].getValue() + limbCount * genes[GeneNames.IRIDESCENCE_RED.ordinal()].getValue()) % 256;
		int green = (genes[GeneNames.COLOR_GREEN.ordinal()].getValue() + limbCount * genes[GeneNames.IRIDESCENCE_GREEN.ordinal()].getValue()) % 256;
		int blue = (genes[GeneNames.COLOR_BLUE.ordinal()].getValue() + limbCount * genes[GeneNames.IRIDESCENCE_BLUE.ordinal()].getValue()) % 256;
		//Prevent length or thickness from going out of bounds
		if (length < 1) length = 1;
		if (length > 10) length = 10;
		if (thickness < 1) thickness = 1;
		if (thickness > 10) thickness = 10;
		// Set the thickness of the branches (Simple Limb only)
		GL11.glLineWidth(thickness);
		for (int b = 0; b < genes[GeneNames.BRANCH.ordinal()].getValue(); b++)
		{
			GL11.glPushMatrix();
			{
				// This allows the distribution of branches to be uniform.
				GL11.glRotatef((float) b * (360.0f / genes[GeneNames.BRANCH.ordinal()].getValue()), 0.0f, 0.0f, 1.0f);
				new CuboidLimb(length, thickness, red, green, blue).draw();
			}
			GL11.glPopMatrix();
			limbCount++;
			// This draws a new set of branches from the end of each existing branch if necessary.
			if (chains > 1)
			{
				GL11.glPushMatrix();
				{
					GL11.glRotatef((float) b * (360.0f / genes[GeneNames.BRANCH.ordinal()].getValue()), 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(0.0f, genes[GeneNames.LENGTH.ordinal()].getValue() + ((genes[GeneNames.CHAIN.ordinal()].getValue() - chains + 1) * genes[GeneNames.LENGTH_INCREMENT.ordinal()].getValue()), 0.0f);
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