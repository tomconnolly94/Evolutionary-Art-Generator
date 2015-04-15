package gui;
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
			
			//TODO: Complete the init method as well as the display method, once this is complete the Biomorph will display in the GUI
			
			
		       @Override
	            public void init( GLAutoDrawable glautodrawable ) {
	            }
	            
	            @Override
	            public void dispose( GLAutoDrawable glautodrawable ) {
	            }
	            
	            @Override
	            public void display( GLAutoDrawable glautodrawable ) {
	               DisplayMode mode = new DisplayMode(1024, 768);
	            	
	            	try
					{
						Display.setDisplayMode(mode);
						Display.create();
						Display.setTitle("Biomorph Display");
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
	                
	            }

				@Override
				public void reshape(GLAutoDrawable glautodrawable, int aspect, int lat, int lon, int zoom)
				{
					Drawer.draw(glautodrawable.getGL(), aspect, lat, lon, zoom);
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

	
