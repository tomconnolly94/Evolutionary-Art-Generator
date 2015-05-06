package evolution;
import java.util.ArrayList;
import javax.swing.JTextArea;
/**
 * Class to take the gene values from a Biomorph and store them to be printed when called.
 * @author Tom Connolly
 * @version 05/05/2015
 */
public class EvolutionStats
{
	private ArrayList<int[]> statsMaster;
	private ArrayList<String> runningStatsString;
	private int[] targetValues;
	private int numOfGenes = 12;
	/*
	 * Constructor initialises all fields and loads the geneNames so that genes can be labelled. also fills arrayList with the names of each gene to be used later.
	 */
	public EvolutionStats(int[] targetValues)
	{
		this.targetValues = targetValues;
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
		for (int i = 0; i < numOfGenes; i++) savedValues[i] = values[i];
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
				runningStatsString.set(dataIndex, runningStatsString.get(dataIndex) + val + spaces);
				System.out.println(runningStatsString.get(dataIndex));
			}
		}
	}
	public JTextArea returnTextAreaStats()
	{
		JTextArea textArea = new JTextArea();
		if (statsMaster.size() >= 1)
		{
			for (int arrayIndex = 0; arrayIndex < statsMaster.size(); arrayIndex++)
			{
				for (int dataIndex = 0; dataIndex < numOfGenes; dataIndex++)
				{
					String spaces = " ~ ";
					String val = Integer.toString(statsMaster.get(arrayIndex)[dataIndex]);
					runningStatsString.set(dataIndex, runningStatsString.get(dataIndex) + val + spaces);
				}
			}
			textArea.append("Gene values for all evolved Biomorphs\n\n");
			textArea.append("This area displays all the gene values of each evolved Biomorph. Each column represents "
					+ "a Biomorphs genes, and each row represents the evolution path of each gene.\n\n");
			for (int i = 0; i < 12; i++) textArea.append(runningStatsString.get(i) + "\n");
		}
		else textArea.append("No Biomorphs have been created please press 'Evolve'");
		return textArea;
	}

	/**
	 * Method to load all the geneNames into an array ready to be used for printing.
	 */
	private ArrayList<String> loadGeneNames()
	{
		String pv = "(PV)~~ ";
		runningStatsString = new ArrayList<String>(numOfGenes);
		runningStatsString.add("Branch\t\t" + targetValues[0] + pv);
		runningStatsString.add("Chain\t\t" + targetValues[1] + pv);
		runningStatsString.add("Color Red\t\t"+ targetValues[2] + pv);
		runningStatsString.add("Color Green\t\t" + targetValues[3] + pv);
		runningStatsString.add("Color Blue\t\t" + targetValues[4] + pv);
		runningStatsString.add("Length\t\t" + targetValues[5] + pv);
		runningStatsString.add("Length Increment\t" + targetValues[6] + pv);
		runningStatsString.add("Thickness\t\t" + targetValues[7] + pv);
		runningStatsString.add("Thickness Increment\t" + targetValues[8] + pv);
		runningStatsString.add("Iridescence Red\t" + targetValues[9] + pv);
		runningStatsString.add("Iridescence Green\t" + targetValues[10] + pv);
		runningStatsString.add("Iridescence Blue\t" + targetValues[11] + pv);
		return runningStatsString;
	}
	public void clearStats()
	{
		statsMaster.clear();
		runningStatsString.clear();
	}
	public void updateTargetValues(int[] targetValues)
	{
		this.targetValues = targetValues;
	}
	public ArrayList<String> getRunningStats()
	{
		return runningStatsString;
	}
}