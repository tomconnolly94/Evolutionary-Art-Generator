package geometry;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
/**
 * Class for a cuboid limb. These are composed of 8 vertices.
 * @author Jack Taylor
 * @version 05/05/2015
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
	public void draw(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		Vertex v1 = new Vertex(-(float) thickness / 10, 0.0f, -(float) thickness / 10, drawable);
		Vertex v2 = new Vertex((float) thickness / 10, 0.0f, -(float) thickness / 10, drawable);
		Vertex v3 = new Vertex(-(float) thickness / 10, 0.0f, (float) thickness / 10, drawable);
		Vertex v4 = new Vertex((float) thickness / 10, 0.0f, (float) thickness / 10, drawable);
		Vertex v5 = new Vertex(-(float) thickness / 10, (float) length, -(float) thickness / 10, drawable);
		Vertex v6 = new Vertex((float) thickness / 10, (float) length, -(float) thickness / 10, drawable);
		Vertex v7 = new Vertex(-(float) thickness / 10, (float) length, (float) thickness / 10, drawable);
		Vertex v8 = new Vertex((float) thickness / 10, (float) length, (float) thickness / 10, drawable);
		gl.glColor3f((float) red / 256, (float) green / 256, (float) blue / 256);
		// Bottom face
		gl.glBegin(GL2.GL_QUADS);
		v1.draw();
		v2.draw();
		v4.draw();
		v3.draw();
		gl.glEnd();
		// Front face
		gl.glBegin(GL2.GL_QUADS);
		v3.draw();
		v4.draw();
		v8.draw();
		v7.draw();
		gl.glEnd();
		// Left face
		gl.glBegin(GL2.GL_QUADS);
		v1.draw();
		v3.draw();
		v7.draw();
		v5.draw();
		gl.glEnd();
		// Right face
		gl.glBegin(GL2.GL_QUADS);
		v4.draw();
		v2.draw();
		v6.draw();
		v8.draw();
		gl.glEnd();
		// Back face
		gl.glBegin(GL2.GL_QUADS);
		v2.draw();
		v1.draw();
		v5.draw();
		v6.draw();
		gl.glEnd();
		// Top face
		gl.glBegin(GL2.GL_QUADS);
		v6.draw();
		v5.draw();
		v7.draw();
		v8.draw();
		gl.glEnd();
	}
}