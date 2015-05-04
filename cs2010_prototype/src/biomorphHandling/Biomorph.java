package biomorphHandling;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import genes.*;
import geometry.*;
/**
 * Class to model and draw a single biomorph.
 * @author Tom Connolly, Jack Taylor
 * @version 24/04/2015
 */
public class Biomorph
{
	//references to this biomorphs mother and father biomorphs
	private Biomorph mother;
	private Biomorph father;
	// List of array indices for genes
	public static final int BRANCH = 0;
	public static final int CHAIN = 1;
	public static final int COLOR_RED = 2;
	public static final int COLOR_GREEN = 3;
	public static final int COLOR_BLUE = 4;
	public static final int LENGTH = 5;
	public static final int LENGTH_INCREMENT = 6;
	public static final int THICKNESS = 7;
	public static final int THICKNESS_INCREMENT = 8;
	public static final int IRIDESCENCE_RED = 9;
	public static final int IRIDESCENCE_GREEN = 10;
	public static final int IRIDESCENCE_BLUE = 11;
	// drawing environment
	private GLAutoDrawable drawable;
	// An array is instantiated to hold 12 Genes that will be defined in the constructor.
	private Gene[] genes = new Gene[12];
	/**
	 * Constructor
	 * @param branch The value of the Branch gene
	 * @param chain The value of the Chain gene
	 * @param red The value of the Color Red gene
	 * @param green The value of the Color Green gene
	 * @param blue The value of the Color Blue gene
	 * @param length The value of the Length gene
	 * @param lengthInc The value of the Length Increment gene
	 * @param thickness The value of the Thickness gene
	 * @param thicknessInc The value of the Thickness Increment gene
	 * @param iridRed The value of the Iridescence Red gene
	 * @param iridGreen The value of the Iridescence Green gene
	 * @param iridBlue The value of the Iridescence Blue gene
	 */
	public Biomorph(Biomorph mother, Biomorph father, int branch, int chain, int red, int green, int blue, int length, int lengthInc, int thickness, int thicknessInc, int iridRed, int iridGreen, int iridBlue)
	{
		// Genes are created and assigned values according to the parameters given. They are then placed in an
		// array in alphabetical (apart from colours which are RGB) order.
		genes[BRANCH] = new Branch(branch, "Branch");
		genes[CHAIN] = new Chain(chain, "Chain");
		genes[COLOR_RED] = new Color(red, "Color Red");
		genes[COLOR_GREEN] = new Color(green, "Color Green");
		genes[COLOR_BLUE] = new Color(blue, "Color Blue");
		genes[LENGTH] = new Length(length, "Length");
		genes[LENGTH_INCREMENT] = new LengthIncrement(lengthInc, "Length Increment");
		genes[THICKNESS] = new Thickness(thickness, "Thickness");
		genes[THICKNESS_INCREMENT] = new ThicknessIncrement(thicknessInc, "Thickness Increment");
		genes[IRIDESCENCE_RED] = new Iridescence(iridRed, "Iridescence Red");
		genes[IRIDESCENCE_GREEN] = new Iridescence(iridGreen, "Iridescence Green");
		genes[IRIDESCENCE_BLUE] = new Iridescence(iridBlue, "Iridescence Blue");
	}
	/**
	 * Draws this biomorph.
	 */
	public void draw(GLAutoDrawable drawable)
	{
		this.drawable = drawable;
		GL2 gl = drawable.getGL().getGL2();
		gl.glPushMatrix();
		{
			loop(genes[CHAIN].getValue(), 0);
			gl.glPushMatrix();
			{
				gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
				loop(genes[CHAIN].getValue(), 0);
				gl.glPushMatrix();
				{
					gl.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
					loop(genes[CHAIN].getValue(), 0);
				}
				gl.glPopMatrix();
			}
			gl.glPopMatrix();
		}
		gl.glPopMatrix();
	}
	/**
	 * Recursive loop to draw chains from each branch.
	 * @param chains The amount of recursive steps
	 * @param limbCount The amount of limbs which have been drawn so far
	 */
	private void loop(int chains, int limbCount)
	{
		GL2 gl = drawable.getGL().getGL2();
		int length = genes[LENGTH].getValue() + ((genes[CHAIN].getValue() - chains) * genes[LENGTH_INCREMENT].getValue());
		int thickness = genes[THICKNESS].getValue() + ((genes[CHAIN].getValue() - chains) * genes[THICKNESS_INCREMENT].getValue());
		int red = (genes[COLOR_RED].getValue() + limbCount * genes[IRIDESCENCE_RED].getValue()) % 256;
		int green = (genes[COLOR_GREEN].getValue() + limbCount * genes[IRIDESCENCE_GREEN].getValue()) % 256;
		int blue = (genes[COLOR_BLUE].getValue() + limbCount * genes[IRIDESCENCE_BLUE].getValue()) % 256;
		// Prevent length or thickness from going out of bounds
		if (length < 1) length = 1;
		if (length > 10) length = 10;
		if (thickness < 1) thickness = 1;
		if (thickness > 10) thickness = 10;
		// Set the thickness of the branches (Simple Limb only)
		gl.glLineWidth(thickness);
		for (int b = 0; b < genes[BRANCH].getValue(); b++)
		{
			gl.glPushMatrix();
			{
				// This allows the distribution of branches to be uniform.
				gl.glRotatef((float) b * (360.0f / genes[BRANCH].getValue()), 0.0f, 0.0f, 1.0f);
				new CuboidLimb(length, thickness, red, green, blue).draw(drawable);
			}
			gl.glPopMatrix();
			limbCount++;
			// This draws a new set of branches from the end of each existing
			// branch if necessary.
			if (chains > 1)
			{
				gl.glPushMatrix();
				{
					gl.glRotatef((float) b * (360.0f / genes[BRANCH].getValue()), 0.0f, 0.0f, 1.0f);
					gl.glTranslatef(0.0f, genes[LENGTH].getValue() + ((genes[CHAIN].getValue() - chains + 1) * genes[LENGTH_INCREMENT].getValue()), 0.0f);
					loop(chains - 1, limbCount);
				}
				gl.glPopMatrix();
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
	
	public Biomorph getMother(){
		return mother;
	}

	public Biomorph getFather(){
		return father;
	}
	public void updateGene(int value, String gene){
		for(int i=0;i<genes.length;i++){
			if(gene.equals(genes[i].getGeneType())){
				genes[i].setValue(value);
			}
		}
	}
}