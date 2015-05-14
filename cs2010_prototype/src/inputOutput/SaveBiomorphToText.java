package inputOutput;
import genes.Gene;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
/**
 * Class to handle exporting of Biomorphs.
 * @author Tom Connolly
 * @version 05/05/2015
 */
public class SaveBiomorphToText
{
	static FileOutputStream fop = null;
	File file;
	/**
	 * Constructor
	 * @param geneValues The array of genes to save
	 * @param fileName The name of the file to save to
	 */
	public SaveBiomorphToText(Gene[] geneValues)
	{
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.home")));
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			file =  new File(fc.getSelectedFile()+".txt");
		}
		try
		{
			String content = "";
			for (Gene gene : geneValues) content = content + gene.getValue() + ",";
			// save file to src
			if (file != null)
			{
				fop = new FileOutputStream(file);
				// if file doesnt exists, then create it
				if (!file.exists()) file.createNewFile();
				// get the content in bytes
				byte[] contentInBytes = content.getBytes();
				fop.write(contentInBytes);
				fop.flush();
				fop.close();
				System.out.println("Genes have been saved.");
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
				
			}
		}
	}
}