package input_output;
import genes.Gene;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;
import biomorphHandling.*;
/**
 * Class to handle exporting of Biomorphs.
 * @author Tom Connolly
 * @version 04/03/2015
 */
public class SaveStatsToText
{
	static FileOutputStream fop = null;
	static File file;
	static String anchorDestination = "src/statisticsTextFiles/";
	/**
	 * Constructor
	 * @param geneValues The array of genes to save
	 * @param fileName The name of the file to save to
	 */
	public SaveStatsToText(ArrayList<String> input, String fileName)
	{
		try
		{
			
			File dir = new File(anchorDestination);
			if (!(dir.exists()))
			{
				dir.mkdir();
			}
			// save file to src
			file = new File(anchorDestination + fileName + ".txt");
			fop = new FileOutputStream(file);
			// if file doesnt exists, then create it
			if (!file.exists())
			{
				file.createNewFile();
			}
			// get the content in bytes
			for(int i=0;i<input.size();i++){
				byte[] contentInBytes = (input.get(i) + "\n").getBytes();
				fop.write(contentInBytes);
			}
			
			fop.flush();
			fop.close();
			System.out.println("Statistics have been saved.");
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
	/**
	 * Main method for testing
	 */
	public static void main(String[] args)
	{
		BiomorphCreator bc = new BiomorphCreator();
		Biomorph biomorph = bc.createBiomorph();
		new SaveBiomorphToText(biomorph.getGenes(), "biomorph");
	}
}