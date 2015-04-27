package input_output;
import genes.Gene;
import gui.OpenGLFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
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
import org.lwjgl.BufferUtils;
import biomorphHandling.BiomorphCreator;
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
	
	public Save(String imageName, String format, GL2 gl, GLCanvas canvas)
	{
		gl.glReadBuffer(gl.GL_FRONT);
		int width = canvas.getWidth();
		int height= canvas.getHeight();
		int bpp = 4; // Assuming a 32-bit display with a byte each for red, green, blue, and alpha.
		ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
		gl.glReadPixels(0, 0, width, height, gl.GL_RGBA, gl.GL_UNSIGNED_BYTE, buffer );
	
		File file = new File("C:/Users/Tom/Pictures/biomorphImages");
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		   
		for(int x = 0; x < width; x++) 
		{
		    for(int y = 0; y < height; y++)
		    {
		        int i = (x + (width * y)) * bpp;
		        int r = buffer.get(i) & 0xFF;
		        int g = buffer.get(i + 1) & 0xFF;
		        int b = buffer.get(i + 2) & 0xFF;
		        image.setRGB(x, height - (y + 1), (0xFF << 24) | (r << 16) | (g << 8) | b);
		    }
		}
		   
		try {
		    ImageIO.write(image, format, file);
		} catch (IOException e) { e.printStackTrace(); }
	}
	public void changeSaveDestination()
	{
	}
	public void saveToPNG()
	{
	}
	public void saveToJPG()
	{
	}
	public void saveToPDF()
	{
	}
	public void serialiseBiomorph()
	{
	}
	public void saveGeneValuesToTextFile(Gene[] geneValues, String fileName)
	{
		try
		{
			String content = "";
			for (Gene gene : geneValues)
			{
				content = content + gene.getValue() + ", ";
			}
			// save file to src
			file = new File("src/" + fileName + ".txt");
			fop = new FileOutputStream(file);
			// if file doesnt exists, then create it
			if (!file.exists())
			{
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println("Genes have been saved.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (fop != null)
				{
					fop.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
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
	
		Save save = new Save("biomorph", ".jpeg", oframe.getGL2(), canvas);
	}
	
	
}