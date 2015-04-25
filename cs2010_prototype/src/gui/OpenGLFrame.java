package gui;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JPanel;
import biomorphHandling.BiomorphManager;
import com.jogamp.opengl.util.*;
public class OpenGLFrame implements GLEventListener
{
	private GL2 gl;
	private GLU glu;
	private float aspect = 1.0f;
	private float lat = 0.0f; // Latitude
	private float lon = 0.0f; // Longitude
	private float zoom = 1.0f;
	private BiomorphManager bm = new BiomorphManager();
	private static JFrame frame = new JFrame("FRAME");
	private static JPanel panel = new JPanel();
	public static void main(String[] args)
	{
		GLCanvas canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		OpenGLFrame oframe = new OpenGLFrame();
		canvas.addGLEventListener(oframe);
		int width = 400;
		int height = 400;
		panel.setSize(width, height);
		frame.setSize(width, height);
		frame.add(canvas);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		frame.add(panel);
		
		FPSAnimator animator = new FPSAnimator(canvas, 60);
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
		lat++;
		lon += 2;
	}
	private void render(GLAutoDrawable drawable)
	{
		// Clear screen and draw biomorph
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glPushMatrix();
		{
			// Positions the camera according to latitude and longitude, as if the biomorph is a globe-like object			
			glu.gluLookAt((float) Math.cos(Math.toRadians(lat)) * -(float)Math.cos(Math.toRadians(lon)), (float)Math.sin(Math.toRadians(lat)), (float)Math.cos(Math.toRadians(lat)) * (float)Math.sin(Math.toRadians(lon)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
			gl.glOrtho(-50.0f * aspect * zoom, 50.0f * aspect * zoom, -50.0f * zoom, 50.0f * zoom, -50.0f * zoom, 50.0f * zoom);
			bm.getSpecific(0).draw(drawable);
		}
		gl.glPopMatrix();
	}

}