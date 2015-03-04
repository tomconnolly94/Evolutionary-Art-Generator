package biomorphHandling;
import org.lwjgl.opengl.GL11;
import genes.*;
import geometry.*;
/**
 * Class to model and draw a single biomorph.
 * @author Tom Connolly, Jack Taylor
 * @version 24/02/2015
 */
public class Biomorph
{
	// An array is instantiated to hold 11 Genes that will be defined in the
	// constructor.
	private Gene[] genes = new Gene[11];
	public Biomorph(int branchVal, int branchIncrementVal, int chainVal, int redVal, int greenVal, int blueVal, int curvatureVal, int lengthVal, int lengthIncrementVal, int thicknessVal, int thicknessIncrementVal)
	{
		/*
		 * Genes are created and assigned values according to the parameters
		 * given. They are then placed in an array in alphabetical (apart from
		 * colours which are RGB) order.
		 */
		genes[0] = new Branch(branchVal, "Branch");
		genes[1] = new BranchIncrement(branchIncrementVal, "Branch Increment");
		genes[2] = new Chain(chainVal, "Chain");
		genes[3] = new Color(redVal, "Color Red");
		genes[4] = new Color(greenVal, "Color Green");
		genes[5] = new Color(blueVal, "Color Blue");
		genes[6] = new Curvature(curvatureVal, "Curvature");
		genes[7] = new Length(lengthVal, "Length");
		genes[8] = new LengthIncrement(lengthIncrementVal, "Length Increment");
		genes[9] = new Thickness(thicknessVal, "Thickness");
		genes[10] = new ThicknessIncrement(thicknessIncrementVal, "Thickness Increment");
	}
	/**
	 * Draws this biomorph.
	 */
	public void draw()
	{
		// Set the thickness of the branches
		GL11.glLineWidth(genes[9].getValue());
		GL11.glPushMatrix();
		GL11.glRotatef(30f, 0.0f, 1.0f, 0.0f);
		loop(genes[2].getValue());
		GL11.glPushMatrix();
		GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
		loop(genes[2].getValue());
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	/**
	 * Recursive loop to draw chains from each branch.
	 * @param chains The amount of recursive steps
	 */
	private void loop(int chains)
	{
		int limbCount = 0;
		int length = genes[7].getValue();
		for (int b = 0; b < genes[0].getValue(); b++)
		{
			GL11.glPushMatrix();
			// This allows the distribution of branches to be uniform.
			GL11.glRotatef((float) b * (360.0f / genes[0].getValue()), 0.0f, 0.0f, 1.0f);
			/* code to update length value using length Increment */
			// length = (genes[7].getValue() + (limbCount*genes[8].getValue()));
			new CuboidLimb(length, genes[9].getValue(), genes[3].getValue(), genes[4].getValue(), genes[5].getValue()).draw();
			/*
			 * GL11.glBegin(GL11.GL_LINES); Draws a branch
			 * GL11.glColor3f((float) Genes[3].getValue() / 256, (float)
			 * Genes[4].getValue() / 256, (float) Genes[5].getValue() / 256);
			 * GL11.glVertex2f(0.0f, 0.0f); GL11.glVertex2f(0.0f, (float)
			 * Genes[7].getValue()); GL11.glEnd();
			 */
			GL11.glPopMatrix();
			limbCount++;
			// This draws a new set of branches from the end of each existing
			// branch if necessary.
			if (chains > 1)
			{
				GL11.glPushMatrix();
				GL11.glRotatef((float) b * (360.0f / genes[0].getValue()), 0.0f, 0.0f, 1.0f);
				GL11.glTranslatef(0.0f, (float) genes[7].getValue(), 0.0f);
				loop(chains - 1);
				GL11.glPopMatrix();
			}
		}
		length = genes[8].getValue();
	}
	/**
	 * @return An array containing a value for each Gene of this biomorph
	 */
	public Gene[] getGenes()
	{
		return genes;
	}
}