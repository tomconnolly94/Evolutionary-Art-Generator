package input_output;
import genes.Gene;
import gui.OpenGLFrame;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jogamp.opengl.glu.mipmap.Image;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import biomorphHandling.*;
import com.jogamp.opengl.util.FPSAnimator;
/**
 * Class to handle exporting of Biomorphs.
 * @author Tom Connolly
 * @version 04/03/2015
 */
public class Save
{
	static FileOutputStream fop = null;
	static File file;
	private String fileDest = "C:/Users/Tom/Pictures/biomorphImages/biomorphImage.png";

	public Save(GLCanvas canvas, GL2 gl) throws AWTException
	{
		BufferedImage screenshot = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics graphics = screenshot.getGraphics();

	/*    ByteBuffer buffer = BufferUtils.createByteBuffer(canvas.getWidth() * canvas.getHeight() * 3);

	    //gl.glReadPixels(0, 0, canvas.getWidth(), canvas.getHeight(), gl.GL_RGB, gl.GL_BYTE, buffer);


	    for (int h = 0; h < canvas.getHeight(); h++) {
	        for (int w = 0; w < canvas.getWidth(); w++) {
	            // The color are the three consecutive bytes, it's like referencing
	            // to the next consecutive array elements, so we got red, green, blue..
	            // red, green, blue, and so on..
	            graphics.setColor(new Color( buffer.get()*2, buffer.get()*2, buffer.get()*2 ));
	            graphics.drawRect(w,canvas.getHeight() - h, 1, 1); // canvas.getHeight() - h is for flipping the image
	        }
	    }*/
	    try {
            ImageIO.write(screenshot, "PNG", new File(fileDest));
        } catch (IOException ex) {
        }
	}
	
	public static void main(String[] args) throws AWTException{
		GLCanvas canvas = new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
		BiomorphCreator bc = new BiomorphCreator();
		OpenGLFrame oframe = new OpenGLFrame(bc.createBiomorph());
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
		
		Save save = new Save(canvas, oframe.getGL2());
	}
	
	
}