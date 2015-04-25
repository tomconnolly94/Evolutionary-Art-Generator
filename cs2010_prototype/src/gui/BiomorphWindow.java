//package gui;
//import java.awt.Dimension;
//import java.awt.Frame;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.util.List;
//import javax.media.nativewindow.NativeSurface;
//import javax.media.nativewindow.WindowClosingProtocol;
//import javax.media.opengl.GL;
//import javax.media.opengl.GL2;
//import javax.media.opengl.GLAnimatorControl;
//import javax.media.opengl.GLAutoDrawable;
//import javax.media.opengl.GLCapabilitiesImmutable;
//import javax.media.opengl.GLDrawable;
//import javax.media.opengl.GLDrawableFactory;
//import javax.media.opengl.GLEventListener;
//import javax.media.opengl.GLException;
//import javax.media.opengl.GLProfile;
//import javax.media.opengl.GLCapabilities;
//import javax.media.opengl.GLRunnable;
//import javax.media.opengl.awt.GLCanvas;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import org.lwjgl.opengl.Display;
//import org.lwjgl.opengl.DisplayMode;
//import org.lwjgl.opengl.GL11;
//import org.lwjgl.opengl.GLContext;
//import org.lwjgl.util.glu.GLU;
//import com.jogamp.common.util.locks.RecursiveLock;
//import biomorphHandling.BiomorphManager;
//
///**
// * The Biomorph window using JOGL and Swing Components
// * 
// * @author Charandeep Rai
// *
// */
//
//public class BiomorphWindow implements GLEventListener{
//
//	private static boolean quit;
//	private boolean keystop;
//	private float aspect;
//	private float lat; // "Latitude", vertical rotation
//	private float lon; // "Longitude", horizontal rotation
//	private float zoom;
//	private BiomorphManager bm;
//	
//	public BiomorphWindow(){
//		
//		// Action Listeners
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e)
//			{
//				//exitApp();
//				System.exit(0);
//			}
//		});
//		
//		//pack and set visible
//		frame.pack();
//		frame.setVisible(true);
//	}
//    
//	@Override
//	public void display(GLAutoDrawable drawable)
//	{
//		update();
//		render(drawable);
//		
//	}
//	
//	public void update(){
//		
//	}
//	
//	public void render(GLAutoDrawable drawable){
//		GL2 gl = drawable.getGL().getGL2();
//		
//	    gl.glBegin(GL.GL_TRIANGLES);
//	    gl.glColor3f(1, 0, 0);
//	    gl.glVertex2d(1, 1);
//	    gl.glVertex2d(0, 1);
//	    gl.glVertex2d(1, -1);
//	    gl.glEnd();
//	}
//	
//	
//	@Override
//	public void dispose(GLAutoDrawable arg0)
//	{
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void init(GLAutoDrawable arg0)
//	{
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4)
//	{
//		// TODO Auto-generated method stub
//		
//	}
//	
//	private void exitApp()
//	{
//		int response = JOptionPane.showConfirmDialog(frame, "Are you sure that you want to quit?", "Quit?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//		if (response == JOptionPane.YES_OPTION)
//		{
//			System.exit(0);
//		}
//	}
//	
//    public static void main(String[] args) {//setup JOGL environment objects
//		GLProfile glpr = GLProfile.getDefault();
//		GLProfile.initSingleton();
//		GLCapabilities glca = new GLCapabilities(glpr);
//		GLCanvas canvas = new GLCanvas();
//		Frame frame = new Frame("Biomorph Window");
//		
//		//setup object properties
//		frame.setPreferredSize(new Dimension(300,300));
//
//		
//		//add components to containers
//		frame.add(canvas);
//		//canvas.addGLEventListener(new BiomorphWindow());
//		
//		
//		
//     
//    }
//}