package gui;
import java.awt.Frame;
import java.util.List;
import javax.media.nativewindow.NativeSurface;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAnimatorControl;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilitiesImmutable;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.GLProfile;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLRunnable;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;
import com.jogamp.common.util.locks.RecursiveLock;
import biomorphHandling.BiomorphManager;

/**
 * The Biomorph window using JOGL and Swing Components
 * 
 * @author Charandeep Rai
 *
 */

public class BiomorphWindows{

	private static boolean quit;
	private boolean keystop;
	private float aspect;
	private float lat; // "Latitude", vertical rotation
	private float lon; // "Longitude", horizontal rotation
	private float zoom;
	private BiomorphManager bm;
	private JFrame frame;
	
	public BiomorphWindows(){
		//setup JOGL properties
		GLProfile glpr = GLProfile.getDefault();
		GLProfile.initSingleton();
		GLCapabilities glca = new GLCapabilities(glpr);
		GLCanvas canvas = new GLCanvas();
		Frame frame = new Frame();
		
		frame.add(canvas);
	}

    public static void main(String[] args) {
     BiomorphWindows bw = new BiomorphWindows(); 
    }
}