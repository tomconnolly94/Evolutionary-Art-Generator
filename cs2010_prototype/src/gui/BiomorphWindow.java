package gui;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import biomorphHandling.Drawer;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * The Biomorph window using JOGL and Swing Components
 * 
 * @author Charandeep Rai
 *
 */
public class BiomorphWindow {
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
			public void display(GLAutoDrawable arg0)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose(GLAutoDrawable arg0)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void init(GLAutoDrawable arg0)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4)
			{
				// TODO Auto-generated method stub

			}

		}
				);
	}
	
	   final JFrame window = new JFrame(); 
       window.getContentPane().add( glcanvas, BorderLayout.CENTER );
       winodw.setSize( 640, 480 );
       window.setVisible( true );
       
       
}
}
