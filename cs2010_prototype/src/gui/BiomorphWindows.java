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
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import biomorphHandling.BiomorphManager;
import biomorphHandling.Drawer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.lwjgl.input.Keyboard;

/**
 * The Biomorph window using JOGL and Swing Components
 * 
 * @author Charandeep Rai
 *
 */

public class BiomorphWindows implements GLEventListener {

	private static boolean quit;
	private boolean keystop;
	private float aspect;
	private float lat; // "Latitude", vertical rotation
	private float lon; // "Longitude", horizontal rotation
	private float zoom;
	private BiomorphManager bm;
	private JFrame frame;
	public BiomorphWindows(){
		quit = false;
		keystop = false;
		aspect = 0.0f;
		lat = 0.0f;
		lon = 0.0f;
		zoom = 1.0f;
		bm = new BiomorphManager();
		
		GLProfile profile = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);

        frame = new JFrame("Test Biomorph Window");
        frame.add(canvas);
        frame.setSize(800, 600);
        frame.setVisible(true);
		
		// Set display to 1024x768, windowed
				DisplayMode mode = new DisplayMode(800, 600);
				try
				{
					Display.setDisplayMode(mode);
					Display.setParent(canvas);
					Display.create();
					
				}
				catch (Exception e)
				{
				}
				// Set the display's aspect ratio (in this case, 4:3)
				aspect = (float) mode.getWidth() / (float) mode.getHeight();
		

        
        

        

        //canvas.addGLEventListener(new BiomorphWindow());
        
        while(quit==false){
        	reshape();
        }
        
	}

    public static void main(String[] args) {
     BiomorphWindows bw = new BiomorphWindows(); 
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        //render(drawable);
    	//Drawer d = new Drawer();
    	
//    	while (dquit == false) {
//    		d.checkInput();
//    		d.draw();
//    	}
//    	frame.destroy();
//    }
    }
    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    }

    public void reshape(/*GLAutoDrawable drawable, int x, int y, int w, int h*/) {
    	// Pressing Enter will generate a new biomorph.
    			/*if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
    			{
    				// evolves two biomorphs together
    				if (keystop == false)
    				{
    					bm.addSpecific(bm.evolveClo(bm.getSpecific(0), bm.getRandomBiomorph()));
    					bm.createAndAdd();
    					keystop = true;
    				}
    			}
    			// This prevents repeated creations of biomorphs while the Enter key
    			// is held down.
    			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN) == false) keystop = false;
    			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) quit = true;
    			if (Keyboard.isKeyDown(Keyboard.KEY_UP)) if (lat < 90.0f) lat += 2.0f;
    			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) if (lat > -90.0f) lat -= 2.0f;
    			if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) lon -= 2.0f;
    			if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) lon += 2.0f;
    			if (Keyboard.isKeyDown(Keyboard.KEY_W)) if (zoom > 0) zoom -= 0.01f;
    			if (Keyboard.isKeyDown(Keyboard.KEY_S)) zoom += 0.01f;
    			if (Display.isCloseRequested()) quit = true;*/
    			
    			// Clear screen and draw biomorph
    			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    			GL11.glPushMatrix();
    			{
    				// Positions the camera according to latitude and longitude, as if
    				// the biomorph is a globe-like object
    				GL11.glOrtho(-80.0f * aspect * zoom, 80.0f * aspect * zoom, -80.0f * zoom, 80.0f * zoom, -80.0f * zoom, 80.0f * zoom);
    				GLU.gluLookAt((float) Math.cos(Math.toRadians(lat)) * -(float) Math.cos(Math.toRadians(lon)), (float) Math.sin(Math.toRadians(lat)), (float) Math.cos(Math.toRadians(lat)) * (float) Math.sin(Math.toRadians(lon)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
    				bm.getSpecific(0).draw();
    			}
    			GL11.glPopMatrix();
    			Display.update();
    			// Limit to 60fps to save CPU usage
    			Display.sync(60);	

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

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4)
	{
		// TODO Auto-generated method stub
		
	}
	public JPanel getContents(){
		 return (JPanel)frame.getContentPane();
		 
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
////	
////	
//	 public JPanel getContents(){
//	 return (JPanel)window.getContentPane();//.add( canvas, BorderLayout.CENTER);
//	   	}
//}
