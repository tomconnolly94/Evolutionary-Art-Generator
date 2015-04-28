package gui;
import input_output.Save;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.lwjgl.BufferUtils;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphCreator;
import biomorphHandling.BiomorphManager;
import com.jogamp.opengl.util.*;
public class OpenGLFrame implements GLEventListener, KeyListener
{
	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	private static final int W = 4;
	private static final int S = 5;
	private boolean keys[] = new boolean[6];
	private static GL2 gl;
	private GLU glu;
	private float aspect = 1.0f;
	private float lat = 0.0f; // Latitude
	private float lon = 0.0f; // Longitude
	private float zoom = 1.0f;
	private Biomorph biomorph;
	private static GLCanvas canvas;
	
	public OpenGLFrame(Biomorph biomorph, GLCanvas canvas){
		this.biomorph=biomorph;
		this.canvas = canvas;
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
			gl.glOrtho(-50.0f * aspect * zoom, 50.0f * aspect * zoom, -50.0f * zoom, 50.0f * zoom, -50.0f * zoom, 50.0f * zoom);
			glu.gluLookAt((float) Math.cos(Math.toRadians(lat)) * -(float)Math.cos(Math.toRadians(lon)), (float)Math.sin(Math.toRadians(lat)), (float)Math.cos(Math.toRadians(lat)) * (float)Math.sin(Math.toRadians(lon)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
			biomorph.draw(drawable);
		}
		gl.glPopMatrix();
		gl.glFlush();
	}
	public void dispose(GLAutoDrawable drawable)
	{
		
	}
	public void keyPressed(KeyEvent key)
	{
		switch (key.getKeyCode())
		{
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_ENTER:
			//bm.addSpecific(bm.evolveClo(bm.getSpecific(0), bm.getRandomBiomorph()));
			//bm.createAndAdd();
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
	
	public static void save() throws AWTException{
		Save save = new Save(canvas);
	}
	
	public static void main(String[] args)
	{
		GLCanvas canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		BiomorphCreator bc = new BiomorphCreator();
		OpenGLFrame oframe = new OpenGLFrame(bc.createBiomorph(),canvas);
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