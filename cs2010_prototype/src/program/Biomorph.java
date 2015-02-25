package program;
import org.lwjgl.opengl.GL11;

import genes.*;
/**
 * Class to model and draw a single biomorph.
 * @author Tom Connolly, Jack Taylor
 * @version 24/02/2015
 */
public class Biomorph
{
	//An array is instantiated to hold 11 Genes that will be defined in the constructor.
	private Gene[] Genes = new Gene[11];
	//Every time the length Gene is used, this variable is incremented
	private int lengthGeneUseCounter = 0;
	private int origLengGeneValue;
	

	public Biomorph(int branchVal, int branchIncrementVal, int chainVal, int redVal, int greenVal, int blueVal, int curvatureVal, int lengthVal, int lengthIncrementVal, int thicknessVal, int thicknessIncrementVal)
	{	
		/*	Genes are created and assigned values according to the parameters given. They are then placed 
		 *	in an array in alphabetical (apart from colours which are RGB) order.*/
		Gene branch = new Branch(branchVal);
		Genes[0] = branch;
		Gene branchIncrement = new BranchIncrement(branchIncrementVal);
		Genes[1] = branchIncrement;
		Gene chain = new Chain(chainVal);
		Genes[2] = chain;
		Gene colorRed = new Color(redVal);
		Genes[3] = colorRed;
		Gene colorGreen = new Color(greenVal);
		Genes[4] = colorGreen;
		Gene colorBlue = new Color(blueVal);
		Genes[5] = colorBlue;
		Gene curvature = new Curvature(curvatureVal);
		Genes[6] = curvature;
		Gene length = new Length(lengthVal);
		Genes[7] = length;
		Gene lengthIncrement = new LengthIncrement(lengthIncrementVal);
		Genes[8] = lengthIncrement;
		Gene thickness = new Thickness(thicknessVal);
		Genes[9] = thickness;
		Gene thicknessIncrement = new ThicknessIncrement(thicknessIncrementVal);
		Genes[10] = thicknessIncrement;
		origLengGeneValue = Genes[7].getValue();
	}
	/**
	 * Draws this biomorph.
	 */
	public void draw()
	{
		//Set the thickness of the branches
		GL11.glLineWidth(Genes[9].getValue());
		loop(Genes[2].getValue());
	}
	/**
	 * Recursive loop to draw chains from each branch.
	 * @param chains The amount of recursive steps
	 */
	private void loop(int chains)
	{ 
		for (int b = 0; b < Genes[0].getValue(); b++)
		{
			GL11.glPushMatrix();
				//This allows the distribution of branches to be uniform.
				GL11.glRotatef((float)b * (360.0f / Genes[0].getValue()), 0.0f, 0.0f, 1.0f);
				GL11.glBegin(GL11.GL_LINES);
					//Draws a branch
					GL11.glColor3f((float)Genes[3].getValue() / 256, (float)Genes[4].getValue() / 256, (float)Genes[5].getValue() / 256);
					GL11.glVertex2f(0.0f, 0.0f);
					/*
					// Code trying to implement LengthIncrement Gene. Needs work.
					int incLength = Genes[8].getValue();
					int length = Genes[7].getValue() + Genes[8].getValue();
					Genes[7].setValue(length);
					lengthGeneUseCounter++;
					double totalArms = Math.pow(Genes[0].getValue(), Genes[2].getValue());
					if(lengthGeneUseCounter>totalArms-1){
						Genes[7].setValue(origLengGeneValue);
					}
					if(Genes[7].getValue()>10){
						Genes[7].setValue(Genes[7].getValue()-10);
					}
					*/
					GL11.glVertex2f(0.0f, (float)Genes[7].getValue());
				GL11.glEnd();
			GL11.glPopMatrix();
			//This draws a new set of branches from the end of each existing branch if necessary.
			if (chains > 0)
			{
				GL11.glPushMatrix();
					GL11.glRotatef((float)b * (360.0f / Genes[0].getValue()), 0.0f, 0.0f, 1.0f);
					GL11.glTranslatef(0.0f, (float)Genes[7].getValue(), 0.0f);
					loop(chains - 1);
				GL11.glPopMatrix();
			}
		}
	}
	/** 
	 * @return An array containing a value for each Gene of this biomorph
	 */
	public Gene[] getGenes()
	{
		return Genes;
	}
}