package gui;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import biomorphHandling.Drawer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * The Biomorph window using JOGL and Swing Components
 * 
 * @author Charandeep Rai
 *
 */
public class BiomorphWindow {
	
	 final JFrame window = new JFrame(); 
	
	public static void main( String [] args) {
		//Sets it to a default GL Profile
		GLProfile profile = GLProfile.getDefault();
		//Sets the OpenGL capabilities 
		GLCapabilities capabilities = new GLCapabilities(profile);
		//Applies those capabilities to a new OpenGL Canvas
		GLCanvas canvas = new GLCanvas( capabilities);

		//Adds OpenGL event listeners to the canvas
		canvas.addGLEventListener( new GLEventListener() {
			
		       @Override
	            public void reshape( GLAutoDrawable glautodrawable, int x, int y, int width, int height ) {
		    	//Need Help with the Method.
	            }
	            
	            @Override
	            public void init( GLAutoDrawable glautodrawable ) {
	            }
	            
	            @Override
	            public void dispose( GLAutoDrawable glautodrawable ) {
	            }
	            
	            @Override
	            public void display( GLAutoDrawable glautodrawable ) {
//				// Need help with this method as well. 
	            	}

		}
				);

	}
	

	protected void initialise()
	{
		window.setSize(640,480);
		window.pack();
		window.setVisible(true);
	}
	
	
	 public JPanel getContents(){
	 return (JPanel)window.getContentPane();//.add( canvas, BorderLayout.CENTER);
	   	}
}

	
