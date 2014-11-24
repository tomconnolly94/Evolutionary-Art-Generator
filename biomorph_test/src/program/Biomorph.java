package program;
import org.lwjgl.opengl.GL11;
import genes.*;
public class Biomorph
{	
	private Gene branch;
	private Gene chain;
	private Gene length;
	private Gene thickness;	
	public Biomorph(int branch, int chain, int length, int thickness)
	{	
		this.branch = new BranchGene(branch);
		this.chain = new ChainGene(chain);
		this.length = new LengthGene(length);
		this.thickness = new ThicknessGene(thickness);	
	}
	public void draw()
	{
		GL11.glLineWidth(thickness.getValue());
		loop(chain.getValue());
	}
	private void loop(int chains)
	{
		for (int b = 0; b < branch.getValue(); b++)
		{
			GL11.glPushMatrix();
				GL11.glRotatef((float)b * (360.0f / branch.getValue()), 0.0f, 0.0f, 1.0f);
				GL11.glBegin(GL11.GL_LINES);
				GL11.glColor3f(1.0f, 1.0f, 1.0f);
				GL11.glVertex2f(0.0f, 0.0f);
				GL11.glVertex2f(0.0f, (float)length.getValue());
				GL11.glEnd();
			GL11.glPopMatrix();
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
	public int getBranchGeneValue()
	{
		return branch.getValue();
	}
	public int getChainGeneValue()
	{
		return chain.getValue();
	}	
	public int getLengthGeneValue()
	{
		return length.getValue();
	}
	public int getThicknessGeneValue()
	{
		return thickness.getValue();
	}
}