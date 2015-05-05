package input_output;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphCreator;
/**
 * Class to handle importing of Biomorphs.
 * @author Tom Connolly
 * @version 05/05/2015
 */
public class Load
{
	private String fileName;
	/**
	 * Constructor
	 * @param fileName The name of the file to load from
	 */
	public Load(String fileName)
	{
		this.fileName = fileName;
	}
	/**
	 * Loads a biomorph
	 * @return The loaded biomorph if successful, otherwise an empty biomorph
	 */
	public Biomorph load()
	{
		Biomorph biomorph = new Biomorph(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/biomorphTextFiles/" + fileName + ".txt"));
			BiomorphCreator bc = new BiomorphCreator();
			String[] parts = new String[12];
			try
			{
				parts = br.readLine().split(",");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			int[] genes = new int[12];
			int i = 0;
			for (String letter : parts)
			{
				System.out.println(letter);
				letter = letter.replaceAll("\\s+", "");
				genes[i] = Integer.parseInt(letter);
				i++;
			}
			biomorph = bc.createBiomorph(null, null, genes[0], genes[1], genes[2], genes[3], genes[4], genes[5], genes[6], genes[7], genes[8], genes[9], genes[10], genes[11]);
			br.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("BIOMORPH TEXT-FILE NOT FOUND");
		}
		catch (IOException e)
		{
		}
		return biomorph;
	}
	/**
	 * Main method for testing
	 */
	public static void main(String[] args) throws IOException
	{
		Load load = new Load("biomorph");
		load.load();
	}
}
