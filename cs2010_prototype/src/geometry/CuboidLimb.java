package geometry;
import org.lwjgl.opengl.GL11;
/**
 * Class for a cuboid limb. These are composed of 8 vertices.
 * @author Jack Taylor
 */
public class CuboidLimb extends Limb
{
	/**
	 * Constructor
	 */
	public CuboidLimb(int length, int thickness, int red, int green, int blue)
	{
		super(length, thickness, red, green, blue);
	}
	/**
	 * Draws this limb.
	 */
	public void draw()
	{
		Vertex v1 = new Vertex(-(float)thickness / 10, 0.0f, -(float)thickness / 10);
		Vertex v2 = new Vertex((float)thickness / 10, 0.0f, -(float)thickness / 10);
		Vertex v3 = new Vertex(-(float)thickness / 10, 0.0f, (float)thickness / 10);
		Vertex v4 = new Vertex((float)thickness / 10, 0.0f, (float)thickness / 10);
		Vertex v5 = new Vertex(-(float)thickness / 10, (float)length, -(float)thickness / 10);
		Vertex v6 = new Vertex((float)thickness / 10, (float)length, -(float)thickness / 10);
		Vertex v7 = new Vertex(-(float)thickness / 10, (float)length, (float)thickness / 10);
		Vertex v8 = new Vertex((float)thickness / 10, (float)length, (float)thickness / 10);
		GL11.glColor3f((float)red / 256, (float)green / 256, (float)blue / 256);
		//Bottom face
		GL11.glBegin(GL11.GL_QUADS);
			v1.draw();
			v2.draw();
			v4.draw();
			v3.draw();
		GL11.glEnd();
		//Front face
		GL11.glBegin(GL11.GL_QUADS);
			v3.draw();
			v4.draw();
			v8.draw();
			v7.draw();
		GL11.glEnd();
		//Left face
		GL11.glBegin(GL11.GL_QUADS);
			v1.draw();
			v3.draw();
			v7.draw();
			v5.draw();
		GL11.glEnd();
		//Right face
		GL11.glBegin(GL11.GL_QUADS);
			v4.draw();
			v2.draw();
			v6.draw();
			v8.draw();
		GL11.glEnd();
		//Back face
		GL11.glBegin(GL11.GL_QUADS);
			v2.draw();
			v1.draw();
			v5.draw();
			v6.draw();
		GL11.glEnd();
		//Top face
		GL11.glBegin(GL11.GL_QUADS);
			v6.draw();
			v5.draw();
			v7.draw();
			v8.draw();
		GL11.glEnd();
	GL11.glEnd();
	}
}