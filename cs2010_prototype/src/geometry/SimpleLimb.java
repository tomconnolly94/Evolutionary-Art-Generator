package geometry;
import org.lwjgl.opengl.GL11;
/**
 * Class for a simple limb. These are flat and are composed of a single line.
 * @author Jack Taylor
 */
public class SimpleLimb extends Limb
{
	/**
	 * Constructor
	 */
	public SimpleLimb(int length, int thickness, int red, int green, int blue)
	{
		super(length, thickness, red, green, blue);
	}
	/**
	 * Draws this limb.
	 */
	public void draw()
	{
		GL11.glLineWidth(thickness);
		GL11.glBegin(GL11.GL_LINES);
		GL11.glColor3f((float) red / 256, (float) green / 256, (float) blue / 256);
		new Vertex(0.0f, 0.0f, 0.0f).draw();
		new Vertex(0.0f, (float) length, 0.0f).draw();
		GL11.glEnd();
	}
}