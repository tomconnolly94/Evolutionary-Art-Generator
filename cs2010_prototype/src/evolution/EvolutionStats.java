package evolution;
import java.util.ArrayList;
/**
 * Class to take the gene values from a Biomorph and store them to be printed when called.
 * @author Tom Connolly
 * @version 28/02/2015
 */
public class EvolutionStats
{
	// Fields
	private ArrayList<int[]> statsMaster;
	private int numOfGenes = 11;
	private ArrayList<String> runningStats;
	/*
	 * Constructor initialises all fields and loads the geneNames so that genes
	 * can be labelled. also fills arrayList with the names of each gene to be
	 * used later.
	 */
	public EvolutionStats()
	{
		statsMaster = new ArrayList<int[]>(50);
		loadGeneNames();
	}
	// Takes an array of integers, and adds its values to the savedValues array.
	public void saveGeneValues(int[] values)
	{
		int[] savedValues = new int[numOfGenes];
		for (int i = 0; i < numOfGenes; i++)
		{
			savedValues[i] = values[i];
		}
		statsMaster.add(savedValues);
	}
	/*
	 * Method to concatenate new gene values to a Sting of old values and print
	 * them all out.
	 */
	public void printRunningStats()
	{
		for (int arrayIndex = statsMaster.size() - 1; arrayIndex < statsMaster.size(); arrayIndex++)
		{
			System.out.println("");
			System.out.println("---------- Iteration " + (arrayIndex + 1) + " ----------");
			System.out.println("");
			for (int dataIndex = 0; dataIndex < numOfGenes; dataIndex++)
			{
				if(dataIndex == 4){
					
				}
				String spaces = " - ";
				String val = Integer.toString(statsMaster.get(arrayIndex)[dataIndex]);
				runningStats.set(dataIndex, runningStats.get(dataIndex) + val + spaces);
				System.out.println(runningStats.get(dataIndex));
			}
		}
	}
	// Method to load all the geneNames into an array ready to be used for
	// printing.
	private void loadGeneNames()
	{
		runningStats = new ArrayList<String>(numOfGenes);
		runningStats.add("Branch              ");
		runningStats.add("Branch Increment    ");
		runningStats.add("Chain               ");
		runningStats.add("Color Red           ");
		runningStats.add("Color Green         ");
		runningStats.add("Color Blue          ");
		runningStats.add("Curvature           ");
		runningStats.add("Length              ");
		runningStats.add("Length Increment    ");
		runningStats.add("Thickness           ");
		runningStats.add("Thickness Increment ");
	}
}