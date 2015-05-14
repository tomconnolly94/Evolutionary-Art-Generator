package inputOutput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
/**
 * Class to handle exporting of Biomorphs.
 * @author Tom Connolly
 * @version 05/05/2015
 */
public class SaveStatsToText
{
	static FileOutputStream fop = null;
	static File file;
	/**
	 * Constructor
	 * @param geneValues The array of genes to save
	 * @param fileName The name of the file to save to
	 */
	public SaveStatsToText(ArrayList<String> input)
	{
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.home")));
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			file =  new File(fc.getSelectedFile()+".txt");
		}
		try
		{
			if(file!=null)
			{
				fop = new FileOutputStream(file);
				file.createNewFile();
				// get the content in bytes
				for (int i = 0; i < input.size(); i++)
				{
					byte[] contentInBytes = (input.get(i) + "\n").getBytes();
					fop.write(contentInBytes);
				}
				fop.flush();
				fop.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (fop != null) fop.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}