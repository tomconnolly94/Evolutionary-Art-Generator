package evolution;

import java.util.ArrayList;

/**
 * Class to model a data processing and displaying machine. Takes the gene values from a Biomorph and 
 * stores them to be printed when called.
 * 
 * @author Tom Connolly
 * @version 28/02/2015
 *
 */
public class EvolutionStats
{
	//Fields
	private ArrayList<int[]> statsMaster;
	private ArrayList<String> names;
	private int numOfGenes = 11;
	private ArrayList<String> run;
	
	/*Constructor initialises all fields and loads the geneNames so that genes can be labelled.
	 * also fills arrayList with the names of each gene to be used later.	*/
	public EvolutionStats(){
		statsMaster = new ArrayList<int[]>(50);
		loadGeneNames();

		run = new ArrayList<String>(numOfGenes);
		for(int i=0; i<numOfGenes; i++){
			run.add(names.get(i));
		}
	}
	//Takes an array of integers, and adds its values to the savedValues array.
	public void saveGeneValues(int[] values){
		int[] savedValues = new int[numOfGenes];
		for(int i=0; i<numOfGenes; i++){
			savedValues[i] = values[i];
		}
		statsMaster.add(savedValues);
	}
	/* Method to concatenate new gene values to a Sting of old values and print them all out. */
	public void printRunningStats(){
		for(int arrayIndex=statsMaster.size()-1; arrayIndex<statsMaster.size(); arrayIndex++){
			System.out.println("");
			System.out.println("---------- Iteration " + (arrayIndex+1) + " ----------");
			System.out.println("");
			for(int dataIndex=0; dataIndex<numOfGenes; dataIndex++){
				String spaces = " - ";
				String val = Integer.toString(statsMaster.get(arrayIndex)[dataIndex]);
				run.set(dataIndex, run.get(dataIndex) + val + spaces );
			}
		}
		for(String line : run){
			System.out.println(line);
		}
	}
	//Method to load all the geneNames into an array ready to be used for printing.
	public void loadGeneNames(){
		names = new ArrayList<String>(numOfGenes);
		names.add("Branch              ");
		names.add("Branch Increment    ");
		names.add("Chain               ");
		names.add("Color Red           ");
		names.add("Color Green         ");
		names.add("Color Blue          ");
		names.add("Curvature           ");
		names.add("Length              ");
		names.add("Length Increment    ");
		names.add("Thickness           ");
		names.add("Thickness Increment ");
	}
}