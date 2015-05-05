package inputOutput;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphCreator;
/**
 * Class to handle importing of Biomorphs.
 * @author Tom Connolly
 * @version 05/05/2015
 */
public class Load
{
	private File file;
	/**
	 * Constructor
	 * @param fileName The name of the file to load from
	 */
	public Load()
	{
	}
	/**
	 * Loads a biomorph
	 * @return The loaded biomorph if successful, otherwise an empty biomorph
	 */
	public Biomorph load()
	{
		
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.home")));
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			file = fc.getSelectedFile();
		}
		Biomorph biomorph = null;
		if(file!=null){
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(file));
				BiomorphCreator bc = new BiomorphCreator();
				String[] parts = new String[12];
				try
				{
					//split the text file into array using delimiter "'"
					parts = br.readLine().split(",");
				}
				catch (IOException e)
				{
					System.out.println("Error code: Genes could not be read.");
				}
				if(parts.length==12){
					int[] genes = new int[12];
					for (int i=0;i<parts.length;i++)
					{
						genes[i] = Integer.parseInt(parts[i]);
					}
					biomorph = bc.createBiomorph(null, null, genes[0], genes[1], genes[2], genes[3], genes[4], genes[5], genes[6], genes[7], genes[8], genes[9], genes[10], genes[11]);
					br.close();
				}
				else{
					System.out.println("File has been corrupted, it has an unexpected number of values.");
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Error code: File not found.");
			}
			catch (IOException e)
			{
			}
		}
		return biomorph;
	}
	/**
	 * Main method for testing
	 */
	public static void main(String[] args) throws IOException
	{
		Load load = new Load();
		load.load();
	}
}
