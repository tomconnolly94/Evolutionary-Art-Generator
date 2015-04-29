package gui;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JPanel;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphCreator;
import com.jogamp.opengl.util.*;
/**
 * An OpenGL window to be displayed within a JPanel in Swing.
 * @author Jack Taylor, Tom Connolly
 * @version 29/04/2015
 */
public class OpenGLFrame implements GLEventListener, KeyListener
{
	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	private static final int W = 4;
	private static final int S = 5;
	private boolean keys[] = new boolean[6];
	private GL2 gl;
	private GLU glu;
	private float aspect = 1.0f;
	private float lat = 0.0f; // Latitude
	private float lon = 0.0f; // Longitude
	private float zoom = 1.0f;
	private Biomorph biomorph;
	private GLCanvas canvas;
	/**
	 * Constructor
	 * @param biomorph The biomorph this window will display.
	 * @param size The size of this window (both width and height), in pixels.
	 */
	public OpenGLFrame(Biomorph biomorph, int size)
	{
		this.biomorph = biomorph;
		canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		canvas.setSize(size, size);
		canvas.addGLEventListener(this);
		canvas.addKeyListener(this);
		FPSAnimator animator = new FPSAnimator(canvas, 60);
		animator.start();
	}
	/**
	 * Initialises this window.
	 */
	public void init(GLAutoDrawable drawable)
	{
		gl = drawable.getGL().getGL2();
		glu = GLU.createGLU(gl);
	}
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h)
	{
		
	}
	/**
	 * Draws the biomorph contained in this window.
	 */
	public void display(GLAutoDrawable drawable)
	{
		if (keys[UP]) if (lat < 90.0f) lat += 2.0f;
		if (keys[DOWN]) if (lat > -90.0f) lat -= 2.0f;
		if (keys[LEFT]) lon -= 2.0f;
		if (keys[RIGHT]) lon += 2.0f;
		if (keys[W]) if (zoom > 0) zoom -= 0.01f;
		if (keys[S]) zoom += 0.01f;
		// Clear screen and draw biomorph
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glPushMatrix();
		{
			// Positions the camera according to latitude and longitude, as if the biomorph is a globe-like object
			gl.glOrtho(-32.0f * aspect * zoom, 32.0f * aspect * zoom, -32.0f * zoom, 32.0f * zoom, -64.0f * zoom, 64.0f * zoom);
			glu.gluLookAt((float) Math.cos(Math.toRadians(lat)) * -(float)Math.cos(Math.toRadians(lon)), (float)Math.sin(Math.toRadians(lat)), (float)Math.cos(Math.toRadians(lat)) * (float)Math.sin(Math.toRadians(lon)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
			biomorph.draw(drawable);
		}
		gl.glPopMatrix();
		gl.glFlush();
	}
	public void dispose(GLAutoDrawable drawable)
	{
		
	}
	/**
	 * Specifies actions when a key has been pressed.
	 */
	public void keyPressed(KeyEvent key)
	{
		switch (key.getKeyCode())
		{
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_UP:
			keys[UP] = true;
			break;
		case KeyEvent.VK_DOWN:
			keys[DOWN] = true;
			break;
		case KeyEvent.VK_LEFT:
			keys[LEFT] = true;
			break;
		case KeyEvent.VK_RIGHT:
			keys[RIGHT] = true;
			break;
		case KeyEvent.VK_W:
			keys[W] = true;
			break;
		case KeyEvent.VK_S:
			keys[S] = true;
			break;

		default:
			break;
	    }
	}
	/**
	 * Specifies actions when a key has been released.
	 */
	public void keyReleased(KeyEvent key)
	{
		switch (key.getKeyCode())
		{
		case KeyEvent.VK_UP:
			keys[UP] = false;
			break;
		case KeyEvent.VK_DOWN:
			keys[DOWN] = false;
			break;
		case KeyEvent.VK_LEFT:
			keys[LEFT] = false;
			break;
		case KeyEvent.VK_RIGHT:
			keys[RIGHT] = false;
			break;
		case KeyEvent.VK_W:
			keys[W] = false;
			break;
		case KeyEvent.VK_S:
			keys[S] = false;
			break;
		default:
			break;
	    }
	}
	public void keyTyped(KeyEvent key)
	{
		
	}
	/**
	 * @return The OpenGL canvas for this window.
	 */
	public GLCanvas getCanvas()
	{
		return canvas;
	}
	/**
	 * @return The biomorph used in this window.
	 */
	public Biomorph getBiomorph()
	{
		return biomorph;
	}
	/**
	 * Replaces the current biomorph.
	 */
	public void setBiomorph(Biomorph biomorph)
	{
		this.biomorph = biomorph;
	}
	/**
	 * Main method for testing.
	 */
	public static void main(String[] args) throws AWTException
	{
		GLCanvas canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		BiomorphCreator bc = new BiomorphCreator();
		OpenGLFrame oframe = new OpenGLFrame(bc.createBiomorph(), 400);
		canvas.addGLEventListener(oframe);
		canvas.addKeyListener(oframe);
		int width = 400;
		int height = 400;
		JFrame frame = new JFrame("FRAME");
		JPanel panel = new JPanel();
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
}