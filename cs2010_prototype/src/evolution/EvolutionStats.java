package evolution;
import java.util.ArrayList;
/**
 * Class to take the gene values from a Biomorph and store them to be printed when called.
 * @author Tom Connolly
 * @version 24/04/2015
 */
public class EvolutionStats
{
	// Fields
	private ArrayList<int[]> statsMaster;
	private ArrayList<String> runningStats;
	private int[] perfectValues;
	private int numOfGenes = 12;
	/*
	 * Constructor initialises all fields and loads the geneNames so that genes
	 * can be labelled. also fills arrayList with the names of each gene to be
	 * used later.
	 */
	public EvolutionStats(int[] perfectValues)
	{
		this.perfectValues = perfectValues;
		statsMaster = new ArrayList<int[]>(50);
		loadGeneNames();
	}
	/**
	 * Takes an array of integers, and adds its values to the savedValues array.
	 * @param values
	 */
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
	 * Method to concatenate new gene values to a Sting of old values and print them all out.
	 */
	public void printRunningStats()
	{
		for (int arrayIndex = statsMaster.size() - 1; arrayIndex < statsMaster.size(); arrayIndex++)
		{
			System.out.println("");
			System.out.println("~~~~~~~~~~ Iteration " + (arrayIndex + 1) + " ~~~~~~~~~~");
			System.out.println("");
			for (int dataIndex = 0; dataIndex < numOfGenes; dataIndex++)
			{
				String spaces = " ~ ";
				String val = Integer.toString(statsMaster.get(arrayIndex)[dataIndex]);
				runningStats.set(dataIndex, runningStats.get(dataIndex) + val + spaces);
				System.out.println(runningStats.get(dataIndex));
			}
		}
	}
	/**
	 * Method to load all the geneNames into an array ready to be used for printing.
	 */
	private void loadGeneNames()
	{
		String pv = "(PV)~~ ";
		runningStats = new ArrayList<String>(numOfGenes);
		runningStats.add("Branch              " + perfectValues[0] + pv);
		runningStats.add("Chain               " + perfectValues[1] + pv);
		runningStats.add("Color Red           " + perfectValues[2] + pv);
		runningStats.add("Color Green         " + perfectValues[3] + pv);
		runningStats.add("Color Blue          " + perfectValues[4] + pv);
		runningStats.add("Length              " + perfectValues[5] + pv);
		runningStats.add("Length Increment    " + perfectValues[6] + pv);
		runningStats.add("Thickness           " + perfectValues[7] + pv);
		runningStats.add("Thickness Increment " + perfectValues[8] + pv);
		runningStats.add("Iridescence Red     " + perfectValues[9] + pv);
		runningStats.add("Iridescence Green   " + perfectValues[10] + pv);
		runningStats.add("Iridescence Blue    " + perfectValues[11] + pv);
	}
}