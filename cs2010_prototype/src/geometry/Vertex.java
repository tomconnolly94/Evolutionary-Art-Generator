package geometry;
import org.lwjgl.opengl.GL11;
/**
 * Class for a 3D vertex. This will be used for each point of a biomorph limb.
 * @author Jack Taylor
 */
public class Vertex
{
	private float x;
	private float y;
	private float z;
	/**
	 * Constructor
	 */
	public Vertex(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * Draws the vertex using its coordinates.
	 */
	public void draw()
	{
		GL11.glVertex3f(x, y, z);
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