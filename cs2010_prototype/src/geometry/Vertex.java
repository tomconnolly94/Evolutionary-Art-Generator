package geometry;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
/**
 * Class for a 3D vertex. This will be used for each point of a biomorph limb.
 * @author Jack Taylor
 * @version 05/05/2015
 */
public class Vertex
{
	private float x;
	private float y;
	private float z;
	private GL2 gl;
	/**
	 * Constructor
	 */
	public Vertex(float x, float y, float z, GLAutoDrawable drawable)
	{
		gl = drawable.getGL().getGL2();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * Draws the vertex using its coordinates.
	 */
	public void draw()
	{
		gl.glVertex3f(x, y, z);
	}
	/**
	 * @return The x position of this vertex.
	 */
	public float getX()
	{
		return x;
	}
	/**
	 * @return The y position of this vertex.
	 */
	public float getY()
	{
		return y;
	}
	/**
	 * @return The z position of this vertex.
	 */
	public float getZ()
	{
		return z;
	}
}