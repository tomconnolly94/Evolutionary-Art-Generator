package input_output;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Class to handle importing of Biomorphs.
 * @author Tom Connolly
 * @version 04/03/2015
 */
public class Load
{
	public Load()
	{
	}
	public void loadGeneValuesFromTextFile(String fileName) throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/" + fileName + ".txt"));
			System.out.println(br.readLine());
			br.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FILE NOT FOUND");
		}
	}
	/*
	 * //main method for testing public static void main(String[] args) throws
	 * IOException{ loadGeneValuesFromTextFile("Biomorph 1"); }
	 */
}
