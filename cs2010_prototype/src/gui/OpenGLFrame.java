package gui;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import biomorphHandling.BiomorphManager;
import com.jogamp.opengl.util.*;
public class OpenGLFrame implements GLEventListener
{
	private static float aspect = 0.0f;
	private float lat = 0.0f; // Latitude
	private float lon = 0.0f; // Longitude
	private float zoom = 1.0f;
	private BiomorphManager bm = new BiomorphManager();
	private GL2 gl;
	private GLU glu;
	public static void main(String[] args)
	{
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);
		GLCanvas canvas = new GLCanvas(caps);
		Frame frame = new Frame("AWT Window Test");
		int width = 400;
		int height = 400;
		frame.setSize(width, height);
		aspect = (float)width / (float)height;
		frame.add(canvas);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		canvas.addGLEventListener(new OpenGLFrame());
		FPSAnimator animator = new FPSAnimator(canvas, 60);
		//animator.add(canvas);
		animator.start();
	}
	public void init(GLAutoDrawable drawable)
	{
		gl = drawable.getGL().getGL2();
		glu = GLU.createGLU(gl);
	}
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h)
	{
		
	}
	public void display(GLAutoDrawable drawable)
	{
		update();
		render(drawable);
	}
	public void dispose(GLAutoDrawable drawable)
	{
		
	}
	private void update()
	{
		
	}
	private void render(GLAutoDrawable drawable)
	{
		// Clear screen and draw biomorph
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glPushMatrix();
		{
			// Positions the camera according to latitude and longitude, as if the biomorph is a globe-like object
			gl.glOrtho(-50.0f * aspect * zoom, 50.0f * aspect * zoom, -50.0f * zoom, 50.0f * zoom, -50.0f * zoom, 50.0f * zoom);
			glu.gluLookAt((float) Math.cos(Math.toRadians(lat)) * -(float)Math.cos(Math.toRadians(lon)), (float)Math.sin(Math.toRadians(lat)), (float)Math.cos(Math.toRadians(lat)) * (float)Math.sin(Math.toRadians(lon)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
			bm.getSpecific(0).draw(drawable);
		}
		gl.glPopMatrix();
	}
}