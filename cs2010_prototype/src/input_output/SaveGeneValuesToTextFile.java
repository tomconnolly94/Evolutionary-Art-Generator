package input_output;
import genes.Gene;
import gui.OpenGLFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import biomorphHandling.*;
import com.jogamp.opengl.util.FPSAnimator;
/**
 * Class to handle exporting of Biomorphs.
 * @author Tom Connolly
 * @version 04/03/2015
 */
public class SaveGeneValuesToTextFile
{
	static FileOutputStream fop = null;
	static File file;

	public SaveGeneValuesToTextFile(Gene[] geneValues, String fileName)
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
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph();
		SaveGeneValuesToTextFile save = new SaveGeneValuesToTextFile(biomorph.getGenes(), "biomorph");
	}
	
	
}