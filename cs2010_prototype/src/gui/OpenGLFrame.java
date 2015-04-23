package gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import biomorphHandling.BiomorphManager;
import com.jogamp.opengl.util.*;

public class OpenGLFrame implements GLEventListener {

	private static boolean quit=false;
	private boolean keystop=false;
	private float aspect=0.0f;
	private float lat=0.0f; // "Latitude", vertical rotation
	private float lon=0.0f; // "Longitude", horizontal rotation
	private float zoom=1.0f;
	private BiomorphManager bm = new BiomorphManager();
	private GLU glu;
	
    public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("AWT Window Test");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(new OpenGLFrame());

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        //animator.add(canvas);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        update();
        render(drawable);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }

    private void update() {
    	
    }

    private void render(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        // Clear screen and draw biomorph
     		gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
     		gl.glPushMatrix();
     		{
     			// Positions the camera according to latitude and longitude, as if
     			// the biomorph is a globe-like object
     			gl.glOrtho(-80.0f * aspect * zoom, 80.0f * aspect * zoom, -80.0f * zoom, 80.0f * zoom, -80.0f * zoom, 80.0f * zoom);
     			glu.gluLookAt((float) Math.cos(Math.toRadians(lat)) * -(float) Math.cos(Math.toRadians(lon)), (float) Math.sin(Math.toRadians(lat)), (float) Math.cos(Math.toRadians(lat)) * (float) Math.sin(Math.toRadians(lon)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
     			bm.getSpecific(0).draw(drawable);
     		}
     		gl.glPopMatrix();
     		
    }
}