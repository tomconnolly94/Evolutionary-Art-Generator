package biomorphHandling;

import genes.Gene;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save
{
	static FileOutputStream fop = null;
	static File file;
	
	
	public Save()
	{
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
	public void saveGeneValuesToTextFile(Gene[] geneValues, String fileName){
		try {
			String content = "";
			for(Gene gene : geneValues){
				content = content + gene + ", ";
			}
			file = new File("src/" + fileName + ".txt");
			fop = new FileOutputStream(file);
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();
 
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			
			System.out.println("Genes have been saved.");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}