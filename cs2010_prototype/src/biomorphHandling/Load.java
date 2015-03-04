package biomorphHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Load
{
	
	public Load(){
		
	}
	
	public void loadGeneValuesFromTextFile(String fileName) throws IOException{
	
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
	
/*	//main method for testing
	public static void main(String[] args) throws IOException{
		loadGeneValuesFromTextFile("Biomorph 1");
	}*/
}
