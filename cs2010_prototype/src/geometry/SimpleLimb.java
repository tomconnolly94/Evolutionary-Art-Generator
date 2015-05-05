package geometry;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
/**
 * Class for a simple limb. These are flat and are composed of a single line.
 * @author Jack Taylor
 * @version 05/05/2015
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
	public void draw(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		gl.glLineWidth(thickness);
		gl.glBegin(GL2.GL_LINES);
		gl.glColor3f((float) red / 256, (float) green / 256, (float) blue / 256);
		new Vertex(0.0f, 0.0f, 0.0f, drawable).draw();
		new Vertex(0.0f, (float) length, 0.0f, drawable).draw();
		gl.glEnd();
	}
}