package inputOutput;
import genes.Gene;
import genes.Length;
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
		System.out.println(geneValues.length);
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.home")));
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			file = fc.getSelectedFile();
		}
		try
		{
			String content = "";
			for (Gene gene : geneValues) content = content + gene.getValue() + ",";
			// save file to src
			if(file!=null){
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
	public static void main(String[] args){
		Gene[] genes = {new Length(0,"b"),new Length(1,"b"),new Length(2,"b"),new Length(3,"b"),new Length(4,"b"),new Length(5,"b"),new Length(6,"b"),new Length(7,"b"),new Length(8,"b"),new Length(9,"b"),new Length(10,"b"),new Length(11,"b")};
		SaveBiomorphToText save = new SaveBiomorphToText(genes);
	}
}