package gui;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import biomorphHandling.Drawer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * The Biomorph window using JOGL and Swing Components
 * 
 * @author Charandeep Rai
 *
 */

public class BiomorphWindow implements GLEventListener {


    public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame("Test Biomorph Window");
        frame.setSize(1024, 768);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(new BiomorphWindow());
    }

    @Override
    public void display(GLAutoDrawable drawable) {
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


    private void render(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2d(1, 1);
        gl.glVertex2d(0, 1);
        gl.glVertex2d(1, -1);
        gl.glEnd();
    }
}




//public class BiomorphWindow {
//	
//	 final JFrame window = new JFrame(); 
//	
//	public static void main( String [] args) {
//		//Sets it to a default GL Profile
//		GLProfile profile = GLProfile.getDefault();
//		//Sets the OpenGL capabilities 
//		GLCapabilities capabilities = new GLCapabilities(profile);
//		//Applies those capabilities to a new OpenGL Canvas
//		GLCanvas canvas = new GLCanvas( capabilities);
//
//		canvas.addGLEventListener( new GLEventListener(){
//			
//			public void display(GLAutoDrawable drawable) {
//			   // update();
//			    render(drawable);
//			}
//
//			public void init(GLAutoDrawable drawable) {
//			}
//
//			public void dispose(GLAutoDrawable drawable) {
//			}
//
//			public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//			}
//	
//		});
//	}
//	
//	private static void render(GLAutoDrawable drawable) {
//	    GL2 gl = drawable.getGL().getGL2();
//	    
//	    // draw a triangle filling the window
//	    gl.glBegin(GL.GL_TRIANGLES);
//	    gl.glColor3f(1, 0, 0);
//	    gl.glVertex2f(-1, -1);
//	    gl.glColor3f(0, 1, 0);
//	    gl.glVertex2f(0, 1);
//	    gl.glColor3f(0, 0, 1);
//	    gl.glVertex2f(1, -1);
//	    gl.glEnd();
//	}
//		
//		//Adds OpenGL event listeners to the canvas
////		canvas.addGLEventListener( new GLEventListener() {
////			
////			//TODO: Complete the init method as well as the display method, once this is complete the Biomorph will display in the GUI
////			
////			
////		       @Override
////	            public void init( GLAutoDrawable glautodrawable ) {
////	            }
////	            
////	            @Override
////	            public void dispose( GLAutoDrawable glautodrawable ) {
////	            }
////	            
//////	            @Override
//////	            public void display( GLAutoDrawable glautodrawable ) {
////////	               DisplayMode mode = new DisplayMode(1024, 768);
////////	            	
////////	            	try
////////					{
////////						Display.setDisplayMode(mode);
////////						Display.create();
////////						Display.setTitle("Biomorph Display");
////////					}
////////					catch (Exception e)
////////					{
////////						e.printStackTrace();
////////					}
////////	                
//////	            }
//////
//////				@Override
//////				public void reshape(GLAutoDrawable glautodrawable, int aspect, int lat, int lon, int zoom)
//////				{
////////					Drawer.draw(glautodrawable.getGL(), aspect, lat, lon, zoom);
//////				}
////
////			
////
////		}
////				);
////
////	}
//	
//
//	protected void initialise()
//	{
//		window.add(canvas);
//		window.setSize(640,480);
//		window.pack();
//		window.setVisible(true);
//	}
//	
//	
//	 public JPanel getContents(){
//	 return (JPanel)window.getContentPane();//.add( canvas, BorderLayout.CENTER);
//	   	}
//}
//
//	
