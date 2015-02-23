package program;
import org.lwjgl.opengl.GL11;
import genes.*;
/**
 * Class to model and draw a single biomorph.
 * @author Tom Connolly, Jack Taylor
 * @version 18/12/2014
 */
public class Biomorph
{	
	private Gene branch;
	private Gene branchIncrement;
	private Gene chain;	
	private Gene colorB;
	private Gene colorG;
	private Gene colorR;
	private Gene curvature;
	private Gene length;
	private Gene lengthIncrement;
	private Gene thickness;	
	private Gene thicknessIncrement;
	
	public Biomorph(int branch, int branchIncrement, int chain, int colorB, int colorG, int colorR, int curvature, int length, int lengthIncrement, int thickness, int thicknessIncrement)
	{	
		this.branch = new Branch(branch);
		this.branchIncrement = new BranchIncrement(branchIncrement);
		this.chain = new Chain(chain);
		this.colorB = new ColorB(colorB);
		this.colorG = new ColorG(colorG);
		this.colorR = new ColorR(colorR);
		this.curvature = new Curvature(curvature);
		this.length = new Length(length);
		this.lengthIncrement = new LengthIncrement(lengthIncrement);
		this.thickness = new Thickness(thickness);
		this.thicknessIncrement = new ThicknessIncrement(thicknessIncrement);
		
	}
	/**
	 * Draws this biomorph.
	 */
	public void draw()
	{
		//Set the thickness of the branches
		GL11.glLineWidth(thickness.getValue());
		loop(chain.getValue());
	}
	/**
	 * Recursive loop to draw chains from each branch.
	 * @param chains The amount of recursive steps
	 */
	private void loop(int chains)
	{
		for (int b = 0; b < branch.getValue(); b++)
		{
			GL11.glPushMatrix();
				//This allows the distribution of branches to be uniform.
				GL11.glRotatef((float)b * (360.0f / branch.getValue()), 0.0f, 0.0f, 1.0f);
				GL11.glBegin(GL11.GL_LINES);
					//Draws a branch
					GL11.glColor3f(1.0f, 1.0f, 1.0f);
					GL11.glVertex2f(0.0f, 0.0f);
					GL11.glVertex2f(0.0f, (float)length.getValue());
				GL11.glEnd();
			GL11.glPopMatrix();
			//This draws a new set of branches from the end of each existing branch if necessary.
			if (chains > 0)
			{
				GL11.glPushMatrix();
					GL11.glRotatef((float)b * (360.0f / branch.getValue()), 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(0.0f, (float)length.getValue(), 0.0f);
					loop(chains - 1);
				GL11.glPopMatrix();
			}
		}
	}
	/**
	 * @return The value of this biomorph's branch gene
	 */
	public int getBranchGeneValue()
	{
		return branch.getValue();
	}
	/**
	 * @return The value of this biomorph's chain gene
	 */
	public int getChainGeneValue()
	{
		return chain.getValue();
	}	
	/**
	 * @return The value of this biomorph's length gene
	 */
	public int getLengthGeneValue()
	{
		return length.getValue();
	}
	/**
	 * @return The value of this biomorph's thickness gene
	 */
	public int getThicknessGeneValue()
	{
		return thickness.getValue();
	}
}